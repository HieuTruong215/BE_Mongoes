package com.homecare.Homecare.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.homecare.Homecare.entity.ProductEntity;

public interface ProductRepository extends MongoRepository<ProductEntity, String> {

}
