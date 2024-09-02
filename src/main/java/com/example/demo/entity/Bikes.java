package com.example.demo.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.UUID;
import java.time.LocalDateTime;

@Entity
@Table(name = "bike")
public class Bikes {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID bike_id;

    @ManyToOne
    @JoinColumn(name = "party_id", nullable = false)
    private Party party;

    private String make;
    private String model;
    private String trim;
    private int year;
    private double mileage;

    @Enumerated(EnumType.STRING)
    private BikeCondition bike_condition;

    private double price;
    private String title;
    private String description;

    @Column(nullable = false)
    private Double lat;

    @Column(nullable = false)
    private Double lng;

    @Column(nullable = false, updatable = false)
    private LocalDateTime start_date;

    @Enumerated(EnumType.STRING)
    private BikeStatus status;

    private String location_info;


    @CreationTimestamp  // Automatically generates timestamp on insert
    @Column(nullable = false, updatable = false) // Optional: prevent updates
    private LocalDateTime created_at;

    // Getters and Setters

    public UUID getBike_id() {
        return bike_id;
    }

    public void setBike_id(UUID bike_id) {
        this.bike_id = bike_id;
    }

    public Party getParty() {
        return party;
    }

    public void setParty(Party party) {
        this.party = party;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getTrim() {
        return trim;
    }

    public void setTrim(String trim) {
        this.trim = trim;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getMileage() {
        return mileage;
    }

    public void setMileage(double mileage) {
        this.mileage = mileage;
    }

    public BikeCondition getBike_condition() {
        return bike_condition;
    }

    public void setBike_condition(BikeCondition bike_condition) {
        this.bike_condition = bike_condition;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public BikeStatus getStatus() {
        return status;
    }

    public void setStatus(BikeStatus status) {
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


enum BikeCondition {
    NEW, USED
}

enum BikeStatus {
    POSTED, PENDING, SOLD
}
