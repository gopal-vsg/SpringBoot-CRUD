package com.example.demo.controller;

import com.example.demo.entity.Bikes;
import com.example.demo.service.BikesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/bikes")
public class BikesController {

    @Autowired
    private BikesService bikesService;

    @GetMapping
    public List<Bikes> getAllBikes() {
        return bikesService.getAllBikes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bikes> getBikeById(@PathVariable UUID id) {
        Optional<Bikes> bike = bikesService.getBikeById(id);
        return bike.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Bikes createBike(@RequestBody Bikes bike) {
        return bikesService.createBike(bike);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Bikes> updateBike(@PathVariable UUID id, @RequestBody Bikes updatedBike) {
        Bikes bike = bikesService.updateBike(id, updatedBike);
        return ResponseEntity.ok(bike);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBike(@PathVariable UUID id) {
        bikesService.deleteBike(id);
        return ResponseEntity.noContent().build();
    }
}
