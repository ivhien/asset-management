package com.task.assetmanagement.repository;

import com.task.assetmanagement.model.LoggingModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoggingRepository extends MongoRepository<LoggingModel, String> {
}
