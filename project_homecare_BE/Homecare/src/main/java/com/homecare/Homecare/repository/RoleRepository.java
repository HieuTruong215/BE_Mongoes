package com.homecare.Homecare.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.homecare.Homecare.entity.ERole;
import com.homecare.Homecare.entity.Role;


public interface RoleRepository extends MongoRepository<Role, String> {
  Optional<Role> findByName(ERole name);
}
