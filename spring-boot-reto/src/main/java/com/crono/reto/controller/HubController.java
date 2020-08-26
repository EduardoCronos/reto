package com.crono.reto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crono.reto.entity.Hub;
import com.crono.reto.service.HubService;

@RestController
@RequestMapping("/hub")
public class HubController {
	
	@Autowired
	private HubService hubService;
	
	@GetMapping
	public ResponseEntity<List<Hub>> getListHub(){
		List<Hub> hub = hubService.listAllHubs();
		
		if (null == hub) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(hub); 
	}

}
