package com.crono.reto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crono.reto.entity.Device;

@Repository
public interface DeviceRepository extends JpaRepository<Device, Long> {
	
}
