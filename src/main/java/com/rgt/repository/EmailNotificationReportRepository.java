package com.rgt.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.rgt.entity.EmailNotificationReportEntity;

@Repository
public interface EmailNotificationReportRepository extends MongoRepository<EmailNotificationReportEntity, Integer>{

	
}
