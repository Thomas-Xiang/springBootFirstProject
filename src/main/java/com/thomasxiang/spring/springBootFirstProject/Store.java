package com.thomasxiang.spring.springBootFirstProject;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int storeId;

    @OneToOne
    @JoinColumn(name = "locationId", referencedColumnName = "locationId")
    private Location location;

    @ManyToMany
    Set<Photo> photos = new HashSet<>();

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Set<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(Set<Photo> photos) {
        this.photos = photos;
    }

    public void addPhotoToStore(Photo photo) {
        this.photos.add(photo);
    }

    public void addPhotosToStore(Set<Photo> photos) {
        this.photos.addAll(photos);
    }

    public void removePhotoFromStore(Photo photo) {
        this.photos.remove(photo);
    }

    public void removePhotosFromStore(Set<Photo> photos) {
        this.photos.removeAll(photos);
    }

}
