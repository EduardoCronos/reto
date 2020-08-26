package com.crono.reto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crono.reto.entity.Device;
import com.crono.reto.service.DeviceService;
import com.crono.reto.validators.Validation;

@RestController
@RequestMapping("/devices")
public class DeviceController {

	@Autowired
	private DeviceService deviceService;
	
	@Autowired
	private Validation validator;

	@GetMapping
	public ResponseEntity<List<Device>> getListDevices() {
		List<Device> dev = deviceService.listAllDevices();

		if (null == dev) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(dev);
	}
	
	@GetMapping(value = "/{deviceId}")
	public ResponseEntity<Device> getDeviceById(@PathVariable("deviceId") Long deviceId){
		Device device = deviceService.getDeviceById(deviceId);
		
		if (null == device) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(device);
	}
	
	@PostMapping
	public ResponseEntity<Long> createDevice(@RequestBody Device device){
		if (!validator.validateQR(device.getQrCode())) {
			return ResponseEntity.notFound().build();
		}
		
		Device deviceCreated = deviceService.createDevice(device);
		
		if (null == deviceCreated) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.status(HttpStatus.CREATED).body(deviceCreated.getId());
	}


}
