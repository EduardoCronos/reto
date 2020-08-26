package com.crono.reto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.crono.reto.entity.Hub;

@Repository
public interface HubRepository extends JpaRepository<Hub, Long>{
	@Query(value = "select * from hub where macaddress = ?1", nativeQuery = true)
	public Hub getHubByMac(String macAddress);
}
