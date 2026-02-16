package com.microservice.InventoryService.kafka;

import com.microservice.InventoryService.event.OrderStatus;
import com.microservice.InventoryService.event.OrderEvent;
import com.microservice.InventoryService.service.InventoryService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class OrderEventConsumer {

    private final InventoryService inventoryService;

    public OrderEventConsumer(
            InventoryService inventoryService) {
        this.inventoryService=inventoryService;
    }


    @KafkaListener(topics = "order-events", groupId = "inventory-group-v20")
    public void handleOrderEvent(OrderEvent event) {

        if (event.getStatus() == OrderStatus.CREATED) {
            inventoryService.reduceStock(
                    event.getProductId(),
                    event.getQuantity()
            );
        }

        if (event.getStatus() == OrderStatus.FAILED) {
            inventoryService.restoreStock(
                    event.getProductId(),
                    event.getQuantity()
            );
        }
    }
}