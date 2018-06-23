package com.vanchack.challange.skipthedishes.controller;

import com.vanchack.challange.skipthedishes.domain.UserScore;
import com.vanchack.challange.skipthedishes.services.reward.RewardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

}
