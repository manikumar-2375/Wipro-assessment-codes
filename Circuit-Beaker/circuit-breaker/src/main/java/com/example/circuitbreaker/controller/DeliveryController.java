package com.example.circuitbreaker.controller;

import com.example.circuitbreaker.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeliveryController {

    @Autowired
    private DeliveryService deliveryService;

    @GetMapping("/api/check-delivery")
    public String checkDeliveryStatus() {
        return deliveryService.getDeliveryStatus();
    }
}
