package com.rgt.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.rgt.entity.RegisterUserEntity;

@Repository
public interface RegisterUserRepository extends MongoRepository<RegisterUserEntity, Long>{


	boolean existsByEmailId(String emailId);

	RegisterUserEntity findByEmailId(String emailId);


}
