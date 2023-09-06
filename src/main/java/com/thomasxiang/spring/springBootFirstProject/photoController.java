package com.thomasxiang.spring.springBootFirstProject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;
import java.util.Set;

@RestController
public class photoController {

    private photoRepository photoRepository;
    private photographerRepository photographerRepository;

    @GetMapping("/")
    public String sayHello() {
        return "Hello! Welcome to the Thomas's Photoshop. You can enjoy and purchase massive art photos from more than 1000 artist.";
    }

    @GetMapping("/photo/new")
    public Photo importNewPhoto(@RequestBody Photo photo) {
        Photo newPhoto = photoRepository.save(photo);
        return newPhoto;
    }

    @GetMapping("/photo/{id}")
    public ResponseEntity<Photo> retrivePhoto(@PathVariable Integer id) {
        Optional<Photo> photo = photoRepository.findById(id);
        if (photo.isPresent()) {
            return new ResponseEntity<>(photo.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @GetMapping("/photo/update/{id}")
    public ResponseEntity<Photo> updatePhoto(@PathVariable Integer id, @RequestBody Photo photo) {
        if (!photoRepository.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            Photo updatedPhoto = photoRepository.save(photo);
            return new ResponseEntity<>(updatedPhoto, HttpStatus.OK);
        }
    }

    @GetMapping("/photo/delete/{id}")
    public ResponseEntity<String> deletePhoto(@PathVariable Integer id) {
        if (!photoRepository.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            photoRepository.deleteById(id);
            return new ResponseEntity<>("Photo " + id + " was deleted", HttpStatus.OK);
        }
    }


}
