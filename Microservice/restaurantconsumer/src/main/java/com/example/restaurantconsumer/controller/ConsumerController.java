package com.example.restaurantconsumer.controller;

import com.example.restaurantconsumer.client.RestaurantClient;
import com.example.restaurantconsumer.model.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List; // ✅ Add this import

@RestController
@RequestMapping("/consume/restaurants")
public class ConsumerController {

    @Autowired
    private RestaurantClient client;

    // GET all restaurants
    @GetMapping
    public List<Restaurant> getAllRestaurants() {
        return client.getRestaurants();
    }

    // GET restaurant by ID
    @GetMapping("/{id}")
    public Restaurant getRestaurantById(@PathVariable int id) {
        return client.getRestaurantById(id);
    }
}
