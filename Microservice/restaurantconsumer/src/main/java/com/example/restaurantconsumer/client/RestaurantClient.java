package com.example.restaurantconsumer.client;

import com.example.restaurantconsumer.model.Restaurant;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "RESTAURANT-PRODUCER")
public interface RestaurantClient {

    @GetMapping("/restaurants")
    List<Restaurant> getRestaurants();

    // ✅ Add this method for ID
    @GetMapping("/restaurants/{id}")
    Restaurant getRestaurantById(@PathVariable("id") int id);
}
