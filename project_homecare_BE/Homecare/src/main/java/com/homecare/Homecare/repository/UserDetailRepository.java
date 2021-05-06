package com.homecare.Homecare.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.homecare.Homecare.entity.User;
import com.homecare.Homecare.entity.UserEntity;

public interface UserDetailRepository extends MongoRepository <UserEntity, String> { 

}
