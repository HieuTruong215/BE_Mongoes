package com.homecare.Homecare.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.homecare.Homecare.entity.ComboEntity;

public interface ComboRepository extends MongoRepository<ComboEntity, String> {
	
}