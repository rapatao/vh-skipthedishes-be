package com.vanchack.challange.skipthedishes.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "restaurantid")
    private Integer id;

    @Column(name = "restaurantdocument")
    private String document;

    @Column(name = "restaurantme")
    private String name;

    @Column(name = "restaurantlatlong")
    private String latLng;

}
