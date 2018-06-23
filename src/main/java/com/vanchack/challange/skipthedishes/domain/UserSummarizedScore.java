package com.vanchack.challange.skipthedishes.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserSummarizedScore {

    private Integer userId;
    private Integer restaurantId;
    private Integer score;

}
