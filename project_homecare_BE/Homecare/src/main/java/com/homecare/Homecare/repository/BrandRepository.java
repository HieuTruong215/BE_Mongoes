package com.homecare.Homecare.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.homecare.Homecare.entity.BrandEntity;
	public interface BrandRepository extends MongoRepository<BrandEntity, String> {	
}
