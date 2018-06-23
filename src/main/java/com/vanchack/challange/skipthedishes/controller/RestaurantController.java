package com.vanchack.challange.skipthedishes.controller;

import com.vanchack.challange.skipthedishes.domain.Restaurant;
import com.vanchack.challange.skipthedishes.services.restaurant.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/restaurants")
@RequiredArgsConstructor
public class RestaurantController {

    private final RestaurantService restaurantService;

    @GetMapping
    public Iterable<Restaurant> allRestaurants() {
        return restaurantService.findAll();
    }

    @PostMapping
    public Restaurant addRestaurant(@RequestBody Restaurant restaurant) {
        return restaurantService.add(restaurant);
    }

    @PutMapping
    public Restaurant updateRestaurant(@RequestBody Restaurant restaurant) {
        return restaurantService.update(restaurant);
    }

}
