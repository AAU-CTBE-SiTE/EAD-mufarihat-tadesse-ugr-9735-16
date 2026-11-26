package com.example.order_service.controller;

import com.example.order_service.client.OrderRequest;
import com.example.order_service.client.OrderResponse;
import com.example.order_service.service.OrderService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService service;

    public OrderController(OrderService service) {
        this.service = service;
    }

    // Create order
    @PostMapping
    public ResponseEntity<OrderResponse> createOrder(
            @RequestBody OrderRequest request) {

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(service.createOrder(request));
    }

    // Get all orders
    @GetMapping
    public List<OrderResponse> getAllOrders() {
        return service.getAllOrders();
    }

    // Get order by order ID
    @GetMapping("/{id}")
    public OrderResponse getOrderById(@PathVariable Long id) {
        return service.getOrderById(id);
    }

    // Get order by customer ID
    @GetMapping("/customer/{customerId}")
    public OrderResponse getOrderByCustomerId(
            @PathVariable String customerId) {

        return service.getOrderByCustomerId(customerId);
    }

    // Delete order
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(
            @PathVariable Long id) {

        service.deleteOrder(id);

        return ResponseEntity.noContent().build();
    }
}