package com.thomasxiang.spring.springBootFirstProject;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int categoryId;

    private String name;

    @ManyToMany
    @JoinTable(name = "photo_category", joinColumns = @JoinColumn(name = "photoId"),
            inverseJoinColumns = @JoinColumn(name = "categoryId"))
    Set<Photo> photos = new HashSet<>();

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(Set<Photo> photos) {
        this.photos = photos;
    }

    public void categoryAddPhoto(Photo photo) {
        this.photos.add(photo);
    }

    public void categoryAddPhotos(Set<Photo> photos) {
        this.photos.addAll(photos);
    }


}
