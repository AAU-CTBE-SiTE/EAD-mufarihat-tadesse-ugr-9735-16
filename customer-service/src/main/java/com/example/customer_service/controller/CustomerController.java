package com.example.customer_service.controller;

import com.example.customer_service.model.Customer;
import com.example.customer_service.service.CustomerService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService service;

    public CustomerController(CustomerService service) {
        this.service = service;
    }

    // Save customer
    @PostMapping
    public ResponseEntity<Customer> saveCustomer(
            @RequestBody Customer customer) {

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(service.saveCustomer(customer));
    }

    // Get all customers
    @GetMapping
    public List<Customer> getAllCustomers() {
        return service.getAllCustomers();
    }

    // Get customer by ID
    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable String id) {
        return service.getCustomerById(id);
    }

    // Delete customer
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(
            @PathVariable String id) {

        service.deleteCustomer(id);

        return ResponseEntity.noContent().build();
    }
}