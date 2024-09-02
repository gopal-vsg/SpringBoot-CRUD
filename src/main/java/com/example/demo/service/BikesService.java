package com.example.demo.service;

import com.example.demo.entity.Bikes;
import com.example.demo.repository.BikesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BikesService {

    @Autowired
    private BikesRepository bikesRepository;  // Updated variable name

    public List<Bikes> getAllBikes() {
        return bikesRepository.findAll();  // Updated method call
    }

    public Optional<Bikes> getBikeById(UUID id) {
        return bikesRepository.findById(id);  // Updated method call
    }

    public Bikes createBike(Bikes bike) {  // Updated return type
        return bikesRepository.save(bike);  // Updated method call
    }

    public Bikes updateBike(UUID id, Bikes updatedBike) {
        return bikesRepository.findById(id)  // Updated method call
                .map(bike -> {  // Updated variable name
                    bike.setMake(updatedBike.getMake());
                    bike.setModel(updatedBike.getModel());
                    bike.setTrim(updatedBike.getTrim());
                    bike.setYear(updatedBike.getYear());
                    bike.setMileage(updatedBike.getMileage());
                    bike.setBike_condition(updatedBike.getBike_condition());
                    bike.setPrice(updatedBike.getPrice());
                    bike.setTitle(updatedBike.getTitle());
                    bike.setLat(updatedBike.getLat());
                    bike.setLng(updatedBike.getLng());
                    bike.setDescription(updatedBike.getDescription());
                    bike.setStatus(updatedBike.getStatus());
                    bike.setLocation_info(updatedBike.getLocation_info());  // Updated variable name for consistency
                    return bikesRepository.save(bike);  // Updated method call
                })
                .orElseThrow(() -> new RuntimeException("Bike not found with id " + id));
    }

    public void deleteBike(UUID id) {
        bikesRepository.deleteById(id);  // Updated method call
    }
}
