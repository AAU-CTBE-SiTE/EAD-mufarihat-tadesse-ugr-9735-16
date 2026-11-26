package com.example.order_service.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class RestConfig {

    @Value("${customer.service.base-url}")
    private String customerServiceUrl;

    @Bean
    public RestClient restClient(RestClient.Builder builder) {

        return builder
                .baseUrl(customerServiceUrl)
                .build();
    }
}
