package com.example.demo.entity;

import jakarta.persistence.*;
import java.util.UUID;
import java.time.LocalDateTime;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "party")
public class Party {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID party_id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;



    private String address;

    private String contact;

    @CreationTimestamp  // Automatically generates timestamp on insert
    @Column(nullable = false, updatable = false) // Optional: prevent updates
    private LocalDateTime created_at;

    // Getters and Setters

    public UUID getParty_id() {
        return party_id;
    }

    public void setParty_id(UUID party_id) {
        this.party_id = party_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    // Removed setter for created_at since it is auto-generated
}
