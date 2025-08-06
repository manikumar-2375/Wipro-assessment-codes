package com.example.restaurantproducer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
 // ✅ Optional with Spring Cloud, but helpful for clarity
public class RestaurantproducerApplication {
    public static void main(String[] args) {
        SpringApplication.run(RestaurantproducerApplication.class, args);
    }
}
// http://localhost:8081/restaurants