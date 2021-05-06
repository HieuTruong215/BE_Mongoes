package com.homecare.Homecare.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.homecare.Homecare.entity.EmployeeEntity;

public interface EmployeeRepository extends MongoRepository<EmployeeEntity, String>{
	  Optional<EmployeeEntity> findByEmail(String email);
	  Boolean existsByEmail(String email);
}
