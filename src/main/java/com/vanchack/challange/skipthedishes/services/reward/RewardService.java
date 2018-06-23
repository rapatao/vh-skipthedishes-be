package com.vanchack.challange.skipthedishes.services.reward;

import com.vanchack.challange.skipthedishes.domain.Restaurant;
import com.vanchack.challange.skipthedishes.domain.User;
import com.vanchack.challange.skipthedishes.domain.UserScore;
import com.vanchack.challange.skipthedishes.services.restaurant.RestaurantService;
import com.vanchack.challange.skipthedishes.services.restaurant.exception.RestaurantNotExistsException;
import com.vanchack.challange.skipthedishes.services.reward.exception.NotEnoughScoreException;
import com.vanchack.challange.skipthedishes.services.user.UserService;
import com.vanchack.challange.skipthedishes.services.user.exception.UserNotExistsException;
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
    private final UserSummarizedScoreRepository userSummarizedScoreRepository;

    public Iterable<UserScore> listScoresByUserAndRestaurant(final Integer userId, final Integer restaurantId) {
        return userScoreRepository.findAllByUserIdAndRestaurantId(userId, restaurantId);
    }

    public UserScore addUserScore(final Integer userId, final Integer restaurantId) {
        final Optional<User> user = userService.byId(userId);
        if (!user.isPresent()) {
            throw new UserNotExistsException();
        }

        final Optional<Restaurant> restaurant = restaurantService.byId(restaurantId);
        if (!restaurant.isPresent()) {
            throw new RestaurantNotExistsException();
        }

        return userScoreRepository.save(UserScore.builder()
                .eventDate(Instant.now())
                .userId(userId)
                .restaurantId(restaurantId)
                .build());
    }

    public void withdrawScore(final Integer userId, final Integer restaurantId, final Integer score) {
        final Optional<User> user = userService.byId(userId);
        if (!user.isPresent()) {
            throw new UserNotExistsException();
        }

        final Optional<Restaurant> restaurant = restaurantService.byId(restaurantId);
        if (!restaurant.isPresent()) {
            throw new RestaurantNotExistsException();
        }

        // FIXME change to use UserSummarizedScore
        final Optional<UserScore> firstByUserIdAndRestaurantId =
                userSummarizedScoreRepository.findFirstByUserIdAndRestaurantId(userId, restaurantId);

        if (firstByUserIdAndRestaurantId.isPresent()) {
            if (firstByUserIdAndRestaurantId.get().getScore().compareTo(score) > 0) {
                // TODO withdraw score
            } else {
                throw new NotEnoughScoreException();
            }

        } else {
            throw new NotEnoughScoreException();
        }
    }

}
