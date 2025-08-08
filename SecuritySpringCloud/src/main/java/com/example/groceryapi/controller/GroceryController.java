package com.example.groceryapi.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/grocery")
public class GroceryController {

    @GetMapping("/public")
    public String publicMessage() {
        return "Welcome to the Grocery Store!";
    }

    @GetMapping("/items")
    public List<String> getItems() {
        return List.of("Rice", "Milk", "Bread", "Fruits");
    }

    @GetMapping("/orders")
    public List<String> getOrders() {
        return List.of("Order1", "Order2", "Order3");
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String adminOnly() {
        return "Hello Admin! This is a secured admin endpoint.";
    }
}
