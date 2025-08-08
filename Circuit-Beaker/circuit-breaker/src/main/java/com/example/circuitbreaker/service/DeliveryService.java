package com.example.circuitbreaker.service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DeliveryService {

    private static final String DELIVERY_API = "http://localhost:8081/delivery/status";

    @CircuitBreaker(name = "deliveryCircuitBreaker", fallbackMethod = "fallbackDeliveryStatus")
    public String getDeliveryStatus() {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(DELIVERY_API, String.class);
    }

    public String fallbackDeliveryStatus(Throwable t) {
        return "Fallback response: Delivery service is currently unavailable. Please try again later.";
    }
}
