package com.example.demo.controller;

import com.example.demo.entity.Parts;
import com.example.demo.service.PartsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/parts")
public class PartsController {

    @Autowired
    private PartsService partsService;

    @GetMapping
    public List<Parts> getAllParts() {
        return partsService.getAllParts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Parts> getPartsById(@PathVariable UUID id) {
        Optional<Parts> parts = partsService.getPartsById(id);
        return parts.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Parts createParts(@RequestBody Parts parts) {
        return partsService.createParts(parts);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Parts> updateParts(@PathVariable UUID id, @RequestBody Parts updatedParts) {
        Parts parts = partsService.updateParts(id, updatedParts);
        return ResponseEntity.ok(parts);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteParts(@PathVariable UUID id) {
        partsService.deleteParts(id);
        return ResponseEntity.noContent().build();
    }
}
