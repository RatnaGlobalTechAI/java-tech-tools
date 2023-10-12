package com.rgt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rgt.entity.EmailNotificationReportEntity;

@Repository
public interface EmailNotificationReportRepository extends JpaRepository<EmailNotificationReportEntity, Long>{

	
}
