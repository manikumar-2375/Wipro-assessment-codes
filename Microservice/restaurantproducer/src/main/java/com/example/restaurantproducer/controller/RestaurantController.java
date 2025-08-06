package com.example.restaurantproducer.controller;

import com.example.restaurantproducer.model.Restaurant;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {

    private List<Restaurant> restaurants = List.of(
        new Restaurant(1, "Dominos", "Hyderabad"),
        new Restaurant(2, "Pizza Hut", "Bangalore")
    );

    @GetMapping
    public List<Restaurant> getAll() {
        return restaurants;
    }

    // ✅ Add this
    @GetMapping("/{id}")
    public Restaurant getById(@PathVariable int id) {
        return restaurants.stream()
                .filter(r -> r.getId() == id)
                .findFirst()
                .orElse(null);
    }
}
