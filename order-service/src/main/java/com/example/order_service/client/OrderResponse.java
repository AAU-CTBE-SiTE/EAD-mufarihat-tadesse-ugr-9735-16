package com.example.order_service.client;

import com.example.order_service.model.Order;

public record OrderResponse(
        Long orderId,
        String orderDescription,
        String customerId,
        CustomerResponse customer
) {

    public static OrderResponse from(
            Order order,
            CustomerResponse customer
    ) {
        return new OrderResponse(
                order.getId(),
                order.getOrderDescription(),
                order.getCustomerId(),
                customer
        );
    }
}