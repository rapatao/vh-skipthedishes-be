package com.vanchack.challange.skipthedishes.services.restaurant;

import com.vanchack.challange.skipthedishes.domain.Restaurant;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

interface RestaurantRepository extends CrudRepository<Restaurant, Integer> {

    Optional<Restaurant> findByDocument(String document);

}
