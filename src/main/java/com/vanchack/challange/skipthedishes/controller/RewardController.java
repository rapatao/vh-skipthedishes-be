package com.vanchack.challange.skipthedishes.controller;

import com.vanchack.challange.skipthedishes.domain.UserScore;
import com.vanchack.challange.skipthedishes.services.reward.RewardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rewards")
@RequiredArgsConstructor
public class RewardController {

    private final RewardService rewardService;

    @GetMapping
    public List<UserScore> listAllByUserAndRestaurant(@RequestParam Integer userId, @RequestParam Integer restaurantId) {
        return (List<UserScore>) rewardService.listScoresByUserAndRestaurant(userId, restaurantId);
    }

    @PostMapping
    public UserScore addScore(@RequestParam Integer userId, @RequestParam Integer restaurantId) {
        return rewardService.addUserScore(userId, restaurantId);
    }

    @DeleteMapping
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void withdraw(@RequestParam Integer userId, @RequestParam Integer restaurantId, @RequestParam Integer score) {
        rewardService.withdrawScore(userId, restaurantId, score);
    }

}
