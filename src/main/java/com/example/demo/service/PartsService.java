package com.example.demo.service;

import com.example.demo.entity.Parts;
import com.example.demo.repository.PartsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PartsService {

    @Autowired
    private PartsRepository partsRepository;

    public List<Parts> getAllParts() {
        return partsRepository.findAll();
    }

    public Optional<Parts> getPartsById(UUID id) {
        return partsRepository.findById(id);
    }

    public Parts createParts(Parts parts) {
        return partsRepository.save(parts);
    }

    public Parts updateParts(UUID id, Parts updatedParts) {
        return partsRepository.findById(id)
                .map(existingParts -> {  // Changed variable name for clarity
                    existingParts.setName(updatedParts.getName());
                    existingParts.setType(updatedParts.getType());
                    existingParts.setPart_condition(updatedParts.getPart_condition());
                    existingParts.setPrice(updatedParts.getPrice());
                    existingParts.setLat(updatedParts.getLat());
                    existingParts.setLng(updatedParts.getLng());
                    existingParts.setDescription(updatedParts.getDescription());
                    existingParts.setStatus(updatedParts.getStatus());
                    existingParts.setLocation_info(updatedParts.getLocation_info());  // Updated to camel case
                    return partsRepository.save(existingParts);  // Save the updated parts
                })
                .orElseThrow(() -> new RuntimeException("Parts not found with id " + id));
    }

    public void deleteParts(UUID id) {
        partsRepository.deleteById(id);
    }
}
