package com.example.demo.repository;


import com.example.demo.entity.Party;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;
public interface PartyRepository extends JpaRepository<Party, UUID> {

}