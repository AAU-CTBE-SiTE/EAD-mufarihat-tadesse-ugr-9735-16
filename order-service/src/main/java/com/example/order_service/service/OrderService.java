package com.example.order_service.service;

import com.example.order_service.client.CustomerClient;
import com.example.order_service.client.CustomerResponse;
import com.example.order_service.client.OrderRequest;
import com.example.order_service.client.OrderResponse;
import com.example.order_service.model.Order;
import com.example.order_service.repository.OrderRepository;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final CustomerClient customerClient;

    public OrderService(
            OrderRepository orderRepository,
            CustomerClient customerClient) {

        this.orderRepository = orderRepository;
        this.customerClient = customerClient;
    }

    // Create order
    public OrderResponse createOrder(OrderRequest request) {

        // First, check whether the customer exists
        CustomerResponse customer =
                customerClient.getCustomerById(request.customerId());

        // Save the order in MySQL
        Order order = new Order(
                request.orderDescription(),
                request.customerId()
        );

        Order savedOrder = orderRepository.save(order);

        return OrderResponse.from(savedOrder, customer);
    }

    // Get all orders with customer information
    public List<OrderResponse> getAllOrders() {

        return orderRepository.findAll()
                .stream()
                .map(order -> {

                    CustomerResponse customer =
                            customerClient.getCustomerById(
                                    order.getCustomerId()
                            );

                    return OrderResponse.from(order, customer);

                })
                .toList();
    }

    // Get order by order ID
    public OrderResponse getOrderById(Long id) {

        Order order = orderRepository.findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                "Order not found"
                        ));

        CustomerResponse customer =
                customerClient.getCustomerById(order.getCustomerId());

        return OrderResponse.from(order, customer);
    }

    // Get order by customer ID
    public OrderResponse getOrderByCustomerId(String customerId) {

        Order order = orderRepository.findByCustomerId(customerId)
                .orElseThrow(() ->
                        new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                "Order not found for this customer"
                        ));

        CustomerResponse customer =
                customerClient.getCustomerById(customerId);

        return OrderResponse.from(order, customer);
    }

    // Delete order
    public void deleteOrder(Long id) {

        if (!orderRepository.existsById(id)) {

            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Order not found"
            );
        }

        orderRepository.deleteById(id);
    }
}