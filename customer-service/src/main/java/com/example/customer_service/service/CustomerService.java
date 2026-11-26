package com.example.customer_service.service;

import com.example.customer_service.model.Customer;
import com.example.customer_service.repository.CustomerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository repository;

    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    // Save customer
    public Customer saveCustomer(Customer customer) {
        return repository.save(customer);
    }

    // Get all customers
    public List<Customer> getAllCustomers() {
        return repository.findAll();
    }

    // Get customer by ID
    public Customer getCustomerById(String id) {

        return repository.findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                "Customer not found"
                        ));
    }

    // Delete customer
    public void deleteCustomer(String id) {

        if (!repository.existsById(id)) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Customer not found"
            );
        }

        repository.deleteById(id);
    }
}