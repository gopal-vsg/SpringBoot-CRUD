package com.example.demo.service;

import com.example.demo.entity.Accessories;
import com.example.demo.repository.AccessoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AccessoriesService {

    @Autowired
    private AccessoriesRepository accessoriesRepository;

    public List<Accessories> getAllAccessories() {
        return accessoriesRepository.findAll();
    }

    public Optional<Accessories> getAccessoriesById(UUID id) {
        return accessoriesRepository.findById(id);
    }

    public Accessories createAccessories(Accessories accessories) {
        return accessoriesRepository.save(accessories);
    }

    public Accessories updateAccessories(UUID id, Accessories updatedAccessories) {
        return accessoriesRepository.findById(id)
                .map(accessories -> {
                    accessories.setName(updatedAccessories.getName());
                    accessories.setType(updatedAccessories.getType());
                    accessories.setPrice(updatedAccessories.getPrice());
                    accessories.setDescription(updatedAccessories.getDescription());
                    accessories.setStatus(updatedAccessories.getStatus());
                    accessories.setLat(updatedAccessories.getLat());
                    accessories.setLng(updatedAccessories.getLng());
                    accessories.setLocation_info(updatedAccessories.getLocation_info());
                    return accessoriesRepository.save(accessories);
                })
                .orElseThrow(() -> new RuntimeException("Accessories not found with id " + id));
    }

    public void deleteAccessories(UUID id) {
        accessoriesRepository.deleteById(id);
    }
}
