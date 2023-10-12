package com.rgt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.rgt.entity.EmailNotificationReportEntity;

import java.util.List;

@Repository
public interface EmailNotificationReportRepository extends JpaRepository<EmailNotificationReportEntity, Long> {
    @Query("SELECT e FROM EmailNotificationReportEntity e WHERE e.email = ?1")
    List<EmailNotificationReportEntity> findEmailNotificationReportEntityByEmail(String email);

}
