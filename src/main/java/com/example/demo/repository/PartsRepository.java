package com.example.demo.repository;


import com.example.demo.entity.Parts;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;
public interface PartsRepository extends JpaRepository<Parts, UUID> {

}