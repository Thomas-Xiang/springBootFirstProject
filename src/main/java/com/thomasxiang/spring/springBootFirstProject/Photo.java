package com.thomasxiang.spring.springBootFirstProject;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "photos")
public class Photo{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer photoId;

    @Column(length = 20)
    private String fileName;

    private float price;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "producer", referencedColumnName = "photographerId")
    Photographer photographer;

    @ManyToMany
    @JoinTable(name = "photo_category", joinColumns = @JoinColumn(name = "photoId"),
            inverseJoinColumns = @JoinColumn(name = "categoryId"))
    Set<Category> categories = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "photo_store", joinColumns = @JoinColumn(name = "photoId"),
            inverseJoinColumns = @JoinColumn(name = "storeId"))
    Set<Store> stores = new HashSet<>();

    public Integer getPhotoId() {
        return photoId;
    }

    public void setPhotoId(Integer photoId) {
        this.photoId = photoId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

    public Photographer getPhotographer() {
        return photographer;
    }

    public void setPhotographer(Photographer photographer) {
        this.photographer = photographer;
    }

    public Set<Store> getStores() {
        return stores;
    }

    public void setStores(Set<Store> stores) {
        this.stores = stores;
    }

    public void addStoreToPhoto(Store store) {
        this.stores.add(store);
    }

    public void addStoresToPhoto(Set<Store> stores) {
        this.stores.addAll(stores);
    }

    public void removeStoreFromPhoto(Store store) {
        this.stores.remove(store);
    }

    public void removeStoresFromPhoto(Set<Store> stores) {
        this.stores.removeAll(stores);
    }

}
