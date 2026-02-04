//package com.microservice.InventoryService.controller;
//
//import com.microservice.InventoryService.entity.InventoryItem;
//import com.microservice.InventoryService.repository.InventoryRepository;
//import com.microservice.InventoryService.service.InventooryService;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.Optional;
//
//@RestController
//@RequestMapping("/inventory")
//public class InventoryController {
//
//    private final InventooryService inventooryService;
//
//    public InventoryController(InventooryService inventooryService) {
//        this.inventooryService = inventooryService;
//    }
//
//    // This is the endpoint that Service A will call
//    @PostMapping("/decrease-stock/{productId}")
//    public ResponseEntity<String> decreaseStock(
//            @PathVariable String productId,
//            @RequestParam int quantityToDecrease) {
//        String response=inventooryService.decreaseStock(productId, quantityToDecrease);
//
//        return ResponseEntity.ok().body(response);
//    }
//}
