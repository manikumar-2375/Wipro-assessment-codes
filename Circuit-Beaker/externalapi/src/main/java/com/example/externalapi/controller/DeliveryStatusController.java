package com.example.externalapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeliveryStatusController {

    @GetMapping("/delivery/status")
    public String getDeliveryStatus() {
        return "Delivered successfully from external API";
    }
}
