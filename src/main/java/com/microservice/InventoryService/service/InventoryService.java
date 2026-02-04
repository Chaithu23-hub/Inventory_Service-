package com.microservice.InventoryService.service;


import com.microservice.InventoryService.entity.InventoryItem;
import com.microservice.InventoryService.repository.InventoryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    public InventoryService(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    @Transactional
    public void reduceStock(String productId, int quantity) {

        InventoryItem item = inventoryRepository.findById(productId)
                .orElseThrow(() ->
                        new RuntimeException("Product not found: " + productId));

        if (item.getQuantity() < quantity) {
            throw new RuntimeException("Insufficient stock for product: " + productId);
        }

        item.setQuantity(item.getQuantity() - quantity);
        inventoryRepository.save(item);
    }

    @Transactional
    public void restoreStock(String productId, int quantity) {

        InventoryItem item = inventoryRepository.findById(productId)
                .orElseThrow(() ->
                        new RuntimeException("Product not found: " + productId));

        item.setQuantity(item.getQuantity() + quantity);
        inventoryRepository.save(item);
    }
}
