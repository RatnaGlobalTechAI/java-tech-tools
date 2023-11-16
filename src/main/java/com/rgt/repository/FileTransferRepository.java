package com.rgt.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.rgt.entity.FileTransferEntity;

@Repository
public interface FileTransferRepository extends MongoRepository<FileTransferEntity , String>{

}
