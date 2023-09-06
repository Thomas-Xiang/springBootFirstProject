package com.thomasxiang.spring.springBootFirstProject;

import jakarta.persistence.*;

import java.security.PrivateKey;

@Entity
@Table(name = "locations")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int locationId;

    @Column(length = 2)
    private String state;

    private String city;

    private int zipcode;


}
