package com.rgt.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.rgt.entity.EmailNotificationReportEntity;

@Repository
public interface EmailNotificationReportRepository extends MongoRepository<EmailNotificationReportEntity, Integer>{

    @Query("SELECT e FROM EmailNotificationReportEntity e WHERE e.email = ?1")
    List<EmailNotificationReportEntity> findEmailNotificationReportEntityByEmail(String email);

}
