package com.thomasxiang.spring.springBootFirstProject;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "photographers")
public class Photographer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer photographerId;

    private String firstName;

    private String lastName;

    @OneToMany(mappedBy = "photographer")
    Set<Photo> products = new HashSet<>();

    public int getPhotographerId() {
        return photographerId;
    }

    public void setPhotographerId(int photographerId) {
        this.photographerId = photographerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<Photo> getProducts() {
        return products;
    }

    public void setProducts(Set<Photo> products) {
        this.products = products;
    }

    public void addToProducer(Photo photo) {
        this.products.add(photo);
    }

    public void addToProducer(Set<Photo> photos) {
        this.products.addAll(photos);
    }
}
