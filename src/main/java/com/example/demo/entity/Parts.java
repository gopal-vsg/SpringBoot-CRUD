package com.example.demo.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.UUID;
import java.time.LocalDateTime;

@Entity
@Table(name = "parts")
public class Parts {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID part_id;

    @ManyToOne
    @JoinColumn(name = "party_id", nullable = false)
    private Party party;

    private String name;
    private String type;

    @Enumerated(EnumType.STRING)
    private PartCondition part_condition;

    private double price;
    private String description;

    @Column(nullable = false, updatable = false)
    private LocalDateTime start_date;

    @Column(nullable = false)
    private Double lat;

    @Column(nullable = false)
    private Double lng;

    @Enumerated(EnumType.STRING)
    private PartStatus status;

    private String location_info;

    @CreationTimestamp  // Automatically generates timestamp on insert
    @Column(nullable = false, updatable = false) // Optional: prevent updates
    private LocalDateTime created_at;

    // Getters and Setters

    public UUID getPart_id() {
        return part_id;
    }

    public void setPart_id(UUID part_id) {
        this.part_id = part_id;
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

    public PartCondition getPart_condition() {
        return part_condition;
    }

    public void setPart_condition(PartCondition part_condition) {
        this.part_condition = part_condition;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
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

    public PartStatus getStatus() {
        return status;
    }

    public void setStatus(PartStatus status) {
        this.status = status;
    }

    public String getLocation_info() {
        return location_info;
    }

    public void setLocation_info(String location_info) {
        this.location_info = location_info;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }
}

// Enum definitions

enum PartCondition {
    NEW, USED
}

enum PartStatus {
    POSTED, PENDING, SOLD
}

