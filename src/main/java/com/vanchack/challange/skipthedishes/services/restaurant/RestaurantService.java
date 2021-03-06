package com.vanchack.challange.skipthedishes.services.restaurant;

import com.vanchack.challange.skipthedishes.domain.Restaurant;
import com.vanchack.challange.skipthedishes.services.restaurant.exception.DuplicatedRestaurantDocumentException;
import com.vanchack.challange.skipthedishes.services.restaurant.exception.RestaurantNotExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;

    public Iterable<Restaurant> findAll() {
        return restaurantRepository.findAll();
    }

    public Restaurant add(Restaurant restaurant) {
        Optional<Restaurant> byDocument = restaurantRepository.findByDocument(restaurant.getDocument());

        if (byDocument.isPresent()) {
            throw new RestaurantAlreadyExists();
        }

        restaurant.setId(null);
        restaurant.setDateSign(Instant.now());

        return restaurantRepository.save(restaurant);
    }

    public Restaurant update(Restaurant restaurant) {
        Optional<Restaurant> byId = restaurantRepository.findById(restaurant.getId());
        if (!byId.isPresent()) {
            throw new RestaurantNotExistsException();
        }
        if (byId.get().getDocument().equalsIgnoreCase(restaurant.getDocument())
                && !byId.get().getId().equals(restaurant.getId())) {
            throw new DuplicatedRestaurantDocumentException();
        }

        restaurant.setDateSign(byId.get().getDateSign());

        return restaurantRepository.save(restaurant);
    }

    public Optional<Restaurant> byId(Integer restaurantId) {
        return restaurantRepository.findById(restaurantId);
    }
}
