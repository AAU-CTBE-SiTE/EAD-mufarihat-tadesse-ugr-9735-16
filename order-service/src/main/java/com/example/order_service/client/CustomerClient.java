package com.example.order_service.client;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClient;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

@Service
public class CustomerClient {

    private final RestClient restClient;

    public CustomerClient(
            @Qualifier("restClient") RestClient restClient) {
        this.restClient = restClient;
    }

    public CustomerResponse getCustomerById(String customerId) {

        try {

            return restClient.get()
                    .uri("/customers/{id}", customerId)
                    .retrieve()
                    .body(CustomerResponse.class);

        } catch (HttpClientErrorException.NotFound ex) {

            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Customer not found in Customer Service"
            );
        }
    }
}
