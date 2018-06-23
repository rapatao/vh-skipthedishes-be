package com.vanchack.challange.skipthedishes.services.reward;

import com.vanchack.challange.skipthedishes.domain.Restaurant;
import com.vanchack.challange.skipthedishes.domain.User;
import com.vanchack.challange.skipthedishes.domain.UserScore;
import com.vanchack.challange.skipthedishes.services.restaurant.RestaurantService;
import com.vanchack.challange.skipthedishes.services.restaurant.exception.RestaurantNotExists;
import com.vanchack.challange.skipthedishes.services.user.UserService;
import com.vanchack.challange.skipthedishes.services.user.exception.UserNotExists;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RewardService {

    private final UserService userService;
    private final RestaurantService restaurantService;
    private final UserScoreRepository userScoreRepository;

    public Iterable<UserScore> listScoresByUserAndRestaurant(final Integer userId, final Integer restaurantId) {
        return userScoreRepository.findAllByUserIdAndRestaurantId(userId, restaurantId);
    }

    public UserScore addUserScore(final UserScore userScore) {
        final Optional<User> user = userService.byId(userScore.getUserId());
        if (!user.isPresent()) {
            throw new UserNotExists();
        }

        final Optional<Restaurant> restaurant = restaurantService.byId(userScore.getRestaurantId());
        if (!restaurant.isPresent()) {
            throw new RestaurantNotExists();
        }

        userScore.setEvent(Instant.now());

        return userScoreRepository.save(userScore);
    }

}
