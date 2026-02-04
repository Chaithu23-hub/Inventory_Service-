package com.microservice.InventoryService.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Data
public class InventoryItem {
    @Id
    private String productId;
    private int quantity;
}
