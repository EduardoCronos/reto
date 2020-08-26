package com.crono.reto.service;

import java.util.List;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.crono.reto.entity.Hub;
import com.crono.reto.repository.HubRepository;

@Service
public class HubServiceImpl implements HubService {

	@Autowired
	private HubRepository hubRepository;

	@Override
	public List<Hub> listAllHubs() {
		return hubRepository.findAll();
	}

	@Override
	public Hub getHubById(Long id) {
		return hubRepository.findById(id).orElse(null);
	}

	@Override
	public Hub createHub(Hub hub) {
		hub.setType(hub.getType());
		hub.setMacAddress(hub.getMacAddress());
		hub.setQrCode(hub.getQrCode());
		hub.setStatus(hub.getStatus());
		return hubRepository.save(hub);
	}

	public String generateMacAddress() {
		Random ran = new Random();
		int low = 10;
		int high = 99;
		Integer next = ran.nextInt(low - high);
		return next.toString();
	}

	public String generateQRCode(int typeDevice) {
		// X es un carácter A-Z en mayúsculas y # es un número
		String format = "XX###XXXX#";
		String qr = "";
		String qrHub = "H1";
		String qrDevice = "D2";
		String value;

		Random c = new Random();
		char caracter;

		for (int i = 0; i < 10; i++) {
			value = format.substring(i);

			if (value.equalsIgnoreCase("X")) {
				caracter = (char) (c.nextInt(26) + 'a');
				qr += Character.toUpperCase(caracter);
			} else if (value.equalsIgnoreCase("#")) {
				Integer numero = (int) (Math.random() * 10 + 1);
				qr += Integer.toString(numero);
			}
		}

		if (typeDevice == 1) {
			// Hub
			qrHub += qr;
		} else if (typeDevice == 2) {
			// Device
			qrDevice += qr;
		} else {
			System.out.println("Fuera de rango");
		}

		return "";
	}

}
