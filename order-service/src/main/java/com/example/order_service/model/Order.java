package com.example.order_service.model;

import jakarta.persistence.*;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String orderDescription;

    @Column(
            name = "customer_id",
            nullable = false,
            unique = true,
            length = 24
    )
    private String customerId;

    public Order() {
    }

    public Order(String orderDescription, String customerId) {
        this.orderDescription = orderDescription;
        this.customerId = customerId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderDescription() {
        return orderDescription;
    }

    public void setOrderDescription(String orderDescription) {
        this.orderDescription = orderDescription;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
}