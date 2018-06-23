package com.vanchack.challange.skipthedishes.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "userid")
    private Integer id;

    @Column(name = "username")
    private String username;

    @Column(name = "usermail")
    private String mail;

    @Column(name = "datesign")
    private Instant dateSign;

}
