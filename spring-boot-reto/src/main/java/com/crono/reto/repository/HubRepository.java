package com.crono.reto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crono.reto.entity.Hub;

@Repository
public interface HubRepository extends JpaRepository<Hub, Long>{

}
