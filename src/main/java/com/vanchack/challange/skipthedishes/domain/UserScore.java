package com.vanchack.challange.skipthedishes.domain;

import lombok.Data;

import javax.persistence.*;
import java.time.Instant;

@Entity(name = "user_score")
@Data
public class UserScore {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "userscoreid")
    private Integer id;

    @Column(name = "userid")
    private Integer userId;

    @Column(name = "restaurantid")
    private Integer restaurantId;

    @Column(name = "score")
    private Integer score;

    @Column(name = "dateuserscore")
    private Instant event;

}
