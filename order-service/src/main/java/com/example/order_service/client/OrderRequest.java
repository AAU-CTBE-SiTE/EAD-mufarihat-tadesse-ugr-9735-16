package com.example.order_service.client;

public record OrderRequest(
        String orderDescription,
        String customerId
) {
}