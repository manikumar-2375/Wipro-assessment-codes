package com.example.restaurantconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.example.restaurantconsumer.client")
@ComponentScan(basePackages = "com.example.restaurantconsumer") // 🔥 Add this if not already there
public class RestaurantconsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(RestaurantconsumerApplication.class, args);
    }
}

// http://localhost:8082/consume/restaurants