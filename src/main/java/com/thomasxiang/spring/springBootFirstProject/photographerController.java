package com.thomasxiang.spring.springBootFirstProject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.Set;

@RestController
public class photographerController {
    private photographerRepository photographerRepository;

    @GetMapping("/photographer/new")
    public Photographer importNewPhotographer(@RequestBody Photographer photographer) {
        Photographer newPhotographer = photographerRepository.save(photographer);
        return newPhotographer;
    }


    @GetMapping("/photographer/{id}")
    public ResponseEntity<Set<Photo>> getPhotoByPhotographer(@PathVariable Integer id) {
        Optional<Photographer> photographer = photographerRepository.findById(id);
        if (photographer.isPresent()) {
            return new ResponseEntity<>(photographer.get().getProducts(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/photographer/update/{id}")
    public ResponseEntity<Photographer> updatePhoto(@PathVariable Integer id, @RequestBody Photographer photographer) {
        if (!photographerRepository.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            Photographer updatedPhotographer = photographerRepository.save(photographer);
            return new ResponseEntity<>(updatedPhotographer, HttpStatus.OK);
        }
    }

    @GetMapping("/photographer/delete/{id}")
    public ResponseEntity<String> deletePhotographer(@PathVariable Integer id) {
        if (!photographerRepository.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            photographerRepository.deleteById(id);
            return new ResponseEntity<>("Photographer " + id + " was deleted", HttpStatus.OK);
        }
    }
}
