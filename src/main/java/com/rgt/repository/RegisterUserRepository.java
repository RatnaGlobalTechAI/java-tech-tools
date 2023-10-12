package com.rgt.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rgt.entity.RegisterUserEntity;

@Repository
public interface RegisterUserRepository extends MongoRepository<RegisterUserEntity, String>{

	@Query("SELECT new com.rgt.entity.RegisterUserEntity(r.username ,r.address , r.city ,r.pincode,r.dob,r.emailId) from RegisterUserEntity r") //WHERE TRUNC(CREATED_ON) >= trunc(sysdate-1)
	List<RegisterUserEntity> getRegisterData();

	boolean existsByEmailId(String emailId);

	//@Query(value = "select * from register_user where emailId= :emailId " , nativeQuery = true)
	RegisterUserEntity findByEmailId(@Param("emailId")String emailId);
	
	@Query("select new com.rgt.entity.RegisterUserEntity(r.username ,r.address , r.city ,r.pincode,r.dob , r.emailId) from RegisterUserEntity r where r.updatedOn >= ?1 and r.updatedOn <= ?2")
	List<RegisterUserEntity> updatedOnTodaysUsers(Date startDate , Date endDate);
	


}
