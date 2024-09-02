package com.example.demo.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.UUID;
import java.time.LocalDateTime;

@Entity
@Table(name = "accessories")
public class Accessories {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID accessory_id;

    @ManyToOne
    @JoinColumn(name = "party_id", nullable = false)
    private Party party;

    private String name;
    private String type;
    private double price;
    private String description;

    @Column(nullable = false)
    private Double lat;

    @Column(nullable = false)
    private Double lng;

    @Column(nullable = false, updatable = false)
    private LocalDateTime start_date;

    @Enumerated(EnumType.STRING)
    private AccessoryStatus status;

    private String location_info;

    @CreationTimestamp  // Automatically generates timestamp on insert
    @Column(nullable = false, updatable = false) // Optional: prevent updates
    private LocalDateTime created_at;

    // Getters and Setters

    public UUID getAccessory_id() {
        return accessory_id;
    }

    public void setAccessory_id(UUID accessory_id) {
        this.accessory_id = accessory_id;
    }

    public Party getParty() {
        return party;
    }

    public void setParty(Party party) {
        this.party = party;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getStart_date() {
        return start_date;
    }

    public void setStart_date(LocalDateTime start_date) {
        this.start_date = start_date;
    }

    public AccessoryStatus getStatus() {
        return status;
    }

    public void setStatus(AccessoryStatus status) {
        this.status = status;
    }

    public String getLocation_info() {
        return location_info;
    }

    public void setLocation_info(String location_info) {
        this.location_info = location_info;
    }
    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }


}

// Enum definition

enum AccessoryStatus {
    POSTED, PENDING, SOLD
}
