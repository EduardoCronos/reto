package com.crono.reto.service;

import java.util.List;

import com.crono.reto.entity.Device;

public interface DeviceService {
	public List<Device> listAllDevices();

	public Device getDeviceById(Long id);

	public Device createDevice(Device device);
}
