package com.vanchack.challange.skipthedishes.services.reward;

import com.vanchack.challange.skipthedishes.domain.Restaurant;
import com.vanchack.challange.skipthedishes.domain.User;
import com.vanchack.challange.skipthedishes.domain.UserScore;
import com.vanchack.challange.skipthedishes.services.restaurant.RestaurantService;
import com.vanchack.challange.skipthedishes.services.restaurant.exception.RestaurantNotExistsException;
import com.vanchack.challange.skipthedishes.services.user.UserService;
import com.vanchack.challange.skipthedishes.services.user.exception.UserNotExistsException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Collections;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

public class RewardServiceTest {

    private UserService userService;
    private RestaurantService restaurantService;
    private UserScoreRepository userScoreRepository;
    private RewardService rewardService;

    @Before
    public void setUp() {
        userService = mock(UserService.class);
        restaurantService = mock(RestaurantService.class);
        userScoreRepository = mock(UserScoreRepository.class);
        rewardService = spy(new RewardService(userService, restaurantService, userScoreRepository));
    }

    @Test(expected = UserNotExistsException.class)
    public void shouldFailWhenUserNotExists() {
        when(userService.byId(anyInt()))
                .thenReturn(Optional.empty());

        rewardService.addUserScore(1, 1);
    }

    @Test(expected = RestaurantNotExistsException.class)
    public void shouldFailWhenRestaurantNotExists() {
        when(userService.byId(anyInt()))
                .thenReturn(Optional.of(User.builder().id(1).build()));

        when(restaurantService.byId(anyInt()))
                .thenReturn(Optional.empty());

        rewardService.addUserScore(1, 1);
    }

    @Test
    public void shouldAddScore() {
        when(userService.byId(anyInt()))
                .thenReturn(Optional.of(User.builder().id(1).build()));

        when(restaurantService.byId(anyInt()))
                .thenReturn(Optional.of(Restaurant.builder().id(1).build()));

        rewardService.addUserScore(1, 1);

        verify(userScoreRepository, times(1))
                .save(any(UserScore.class));
    }

    @Test
    public void shouldReturnEmptyListWhenUserDoesNotHaveScoresOnTheRestaurant() {
        when(userScoreRepository.findAllByUserIdAndRestaurantId(anyInt(), anyInt()))
                .thenReturn(Collections.emptyList());

        final Iterable<UserScore> userScores = rewardService.listScoresByUserAndRestaurant(1, 1);

        Assert.assertNotNull(userScores);
        Assert.assertFalse(userScores.iterator().hasNext());
    }

    @Test
    public void shouldReturnIterableListWhenUserHaveScores() {
        when(userScoreRepository.findAllByUserIdAndRestaurantId(anyInt(), anyInt()))
                .thenReturn(Collections.singletonList(UserScore.builder().build()));

        final Iterable<UserScore> userScores = rewardService.listScoresByUserAndRestaurant(1, 1);

        Assert.assertNotNull(userScores);
        Assert.assertTrue(userScores.iterator().hasNext());
    }


}