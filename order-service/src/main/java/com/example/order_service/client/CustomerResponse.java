package com.example.order_service.client;

public record CustomerResponse(
        String id,
        String name,
        String email
) {
}