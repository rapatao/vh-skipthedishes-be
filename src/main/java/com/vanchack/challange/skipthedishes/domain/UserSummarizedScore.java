package com.vanchack.challange.skipthedishes.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserSummarizedScore {

    private Integer userId;
    private Integer restaurantId;
    private Integer score;

}
