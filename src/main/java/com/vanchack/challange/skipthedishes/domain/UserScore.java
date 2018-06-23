package com.vanchack.challange.skipthedishes.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;

@Entity(name = "user_score")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserScore {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "userscoreid")
    private Integer id;

    @Column(name = "userid")
    private Integer userId;

    @Column(name = "restaurantid")
    private Integer restaurantId;

    @Column(name = "userscore")
    private Integer score;

    @Column(name = "dateuserscore")
    private Instant eventDate;

}
