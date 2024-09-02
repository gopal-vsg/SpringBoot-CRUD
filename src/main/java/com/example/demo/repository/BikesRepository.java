package com.example.demo.repository;


import com.example.demo.entity.Bikes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;
public interface BikesRepository extends JpaRepository<Bikes, UUID> {

}