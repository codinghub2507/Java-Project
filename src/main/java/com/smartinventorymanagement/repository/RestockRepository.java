package com.smartinventorymanagement.repository;

import com.smartinventorymanagement.model.RestockRequest;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestockRepository extends MongoRepository<RestockRequest, String> {
}
