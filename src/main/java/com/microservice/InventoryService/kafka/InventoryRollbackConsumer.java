//package com.microservice.InventoryService.kafka;
//
//import com.microservice.InventoryService.entity.InventoryItem;
//import com.microservice.InventoryService.event.OrderFailedEvent;
//import com.microservice.InventoryService.repository.InventoryRepository;
//import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.stereotype.Service;
//
//@Service
//public class InventoryRollbackConsumer {
//
//    private final InventoryRepository inventoryRepository;
//
//    public InventoryRollbackConsumer(InventoryRepository inventoryRepository) {
//        this.inventoryRepository = inventoryRepository;
//    }
//
//    @KafkaListener(topics = "order-failed", groupId = "inventory-group-v9")
//    public void rollbackStock(OrderFailedEvent event) {
//
//        InventoryItem item = inventoryRepository
//                .findById(event.getProductId())
//                .orElseThrow();
//
//        item.setQuantity(item.getQuantity() + event.getQuantity());
//        inventoryRepository.save(item);
//    }
//}
//
