package com.example.order.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/order")
public class OrderController {

    Logger logger = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping
    public String placeOrder() {
        logger.info("Order placed. Calling payment service...");
        String response = restTemplate.getForObject("http://localhost:8082/payment", String.class);
        return "Order Success. " + response;
    }
}
