package com.crono.reto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crono.reto.entity.Device;
import com.crono.reto.repository.DeviceRepository;

@Service
public class DeviceServiceImpl implements DeviceService{
	
	@Autowired
	private DeviceRepository deviceRepository;
	
	@Override
	public List<Device> listAllDevices() {
		return deviceRepository.findAll();
	}
	
	@Override
	public Device getDeviceById(Long id) {
		return deviceRepository.findById(id).orElse(null);
	}

	@Override
	public Device createDevice(Device device) {
		Device dev = new Device();
		dev.setType(device.getType());
		dev.setMacAddress(device.getMacAddress());
		dev.setQrCode(device.getQrCode());
		dev.setStatus(device.getStatus());
		dev.setIdHub(device.getIdHub());
		return deviceRepository.save(dev);
	}


	

	
	
}
