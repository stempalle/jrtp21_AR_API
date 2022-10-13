package com.sharathit.repo;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sharathit.entity.CitizenAppEntity;

public interface CitizenAppRepository extends JpaRepository<CitizenAppEntity,Serializable> {
	
	
	

}
