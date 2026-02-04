package com.microservice.InventoryService.repository;

import com.microservice.InventoryService.entity.InventoryItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<InventoryItem, String> {

}