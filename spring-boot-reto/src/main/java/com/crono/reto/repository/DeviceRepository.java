package com.crono.reto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crono.reto.entity.Device;

public interface DeviceRepository extends JpaRepository<Device, Long> {
	
}
