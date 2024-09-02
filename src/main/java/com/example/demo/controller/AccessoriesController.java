package com.example.demo.controller;

import com.example.demo.entity.Accessories;
import com.example.demo.service.AccessoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/accessories")
public class AccessoriesController {

    @Autowired
    private AccessoriesService accessoriesService;

    @GetMapping
    public List<Accessories> getAllAccessories() {
        return accessoriesService.getAllAccessories();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Accessories> getAccessoriesById(@PathVariable UUID id) {
        Optional<Accessories> accessories = accessoriesService.getAccessoriesById(id);
        return accessories.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Accessories createAccessories(@RequestBody Accessories accessories) {
        return accessoriesService.createAccessories(accessories);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Accessories> updateAccessories(@PathVariable UUID id, @RequestBody Accessories updatedAccessories) {
        Accessories accessories = accessoriesService.updateAccessories(id, updatedAccessories);
        return ResponseEntity.ok(accessories);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAccessories(@PathVariable UUID id) {
        accessoriesService.deleteAccessories(id);
        return ResponseEntity.noContent().build();
    }
}

