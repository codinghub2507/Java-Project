package com.smartinventorymanagement.repository;

import com.smartinventorymanagement.model.InventoryItem;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository extends MongoRepository<InventoryItem, String> {
}
