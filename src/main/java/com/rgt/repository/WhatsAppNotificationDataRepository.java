package com.rgt.repository;

import java.util.Date;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.rgt.entity.WhatsAppNotificationDataEntity;

@Repository
public interface WhatsAppNotificationDataRepository extends MongoRepository<WhatsAppNotificationDataEntity, Long> {

	WhatsAppNotificationDataEntity findByMobileNumber(String mobileNumber);

}
