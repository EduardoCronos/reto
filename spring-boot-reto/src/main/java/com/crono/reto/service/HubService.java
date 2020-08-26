package com.crono.reto.service;

import java.util.List;

import com.crono.reto.entity.Hub;

public interface HubService {
	public List<Hub> listAllHubs();
	public Hub getHubByMac(String id);
	public Hub createHub(Hub hub);
}
