package com.vanchack.challange.skipthedishes.domain;

import lombok.Data;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "userid")
    private Integer userid;

    @Column(name = "username")
    private String username;

    @Column(name = "usermail")
    private String usermail;

    @Column(name = "dateSign")
    private Instant dateSign;

}
