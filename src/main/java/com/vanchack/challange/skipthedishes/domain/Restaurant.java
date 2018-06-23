package com.vanchack.challange.skipthedishes.domain;

import lombok.Data;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Data
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "restaurantid")
    private Integer id;

    @Column(name = "restaurantdocument")
    private String document;

    @Column(name = "restaurantname")
    private String name;

    @Column(name = "restaurantlatitude")
    private String latitude;

    @Column(name = "restaurantlongitude")
    private String longitude;

    @Column(name = "datesign")
    private Instant dateSign;

    @Column(name = "restaurantaddress")
    private String address;

}
