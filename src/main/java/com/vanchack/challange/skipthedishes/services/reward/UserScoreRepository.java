package com.vanchack.challange.skipthedishes.services.reward;

import com.vanchack.challange.skipthedishes.domain.UserScore;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
interface UserScoreRepository extends CrudRepository<UserScore, Integer> {

    Iterable<UserScore> findAllByUserIdAndRestaurantId(Integer userId, Integer restaurantId);

}
