package com.smartinventorymanagement.service;

import com.smartinventorymanagement.model.InventoryItem;
import com.smartinventorymanagement.repository.InventoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryService {

    private final InventoryRepository repo;

    public InventoryService(InventoryRepository repo) {
        this.repo = repo;
    }

    public List<InventoryItem> getAllItems() {
        return repo.findAll();
    }

    public InventoryItem addItem(InventoryItem item) {
        return repo.save(item);
    }

    public void deleteItem(String id) {
        repo.deleteById(id);
    }

    public int getLowStockItems() {
        return (int) repo.findAll().stream().filter(item -> item.getQuantity() < 5).count();
    }

    public int getTotalItems() {
        return (int) repo.count();
    }

    public int getSoldToday() {
        // Placeholder for simplicity; implement real logic as needed
        return 0;
    }
}
