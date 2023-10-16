package com.rgt.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.rgt.entity.AuditLogEntity;

@Repository
public interface AuditLogRepository extends MongoRepository<AuditLogEntity, Long>{

}
