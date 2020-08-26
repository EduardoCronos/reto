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
import com.crono.reto.entity.Hub;
import com.crono.reto.service.HubService;
import com.crono.reto.validators.Validation;

@RestController
@RequestMapping("/hub")
public class HubController {
	
	@Autowired
	private HubService hubService;
	
	@Autowired
	private Validation validator;
	
	@GetMapping
	public ResponseEntity<List<Hub>> getListHub(){
		List<Hub> hub = hubService.listAllHubs();
		
		if (null == hub) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(hub); 
	}
	
	@GetMapping(value = "/{macaddress}")
	public ResponseEntity<Hub> getDeviceById(@PathVariable("macaddress") String macaddress){
		Hub hub = hubService.getHubByMac(macaddress); 
		
		if (null == hub) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(hub);
	}
	
	@PostMapping
	public ResponseEntity<Long> createHub(@RequestBody Hub hub){
		
		if (!validator.validateQR(hub.getQrCode())) {
			return ResponseEntity.notFound().build();
		}
		
		Hub hubCreated = hubService.createHub(hub);
		
		if (null == hubCreated) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.status(HttpStatus.CREATED).body(hubCreated.getId());
	}

}
