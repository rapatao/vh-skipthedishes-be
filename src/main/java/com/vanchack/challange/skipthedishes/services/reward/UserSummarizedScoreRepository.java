package com.vanchack.challange.skipthedishes.services.reward;

import com.vanchack.challange.skipthedishes.domain.UserScore;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
interface UserSummarizedScoreRepository extends CrudRepository<UserScore, Integer> {

    Optional<UserScore> findFirstByUserIdAndRestaurantId(Integer userId, Integer restaurantId);

}
