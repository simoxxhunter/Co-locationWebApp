package com.colocation.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ListingsModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private double rent;
    private int bedrooms;
    private int bathrooms;
    private String address;

    @ElementCollection
    private List<String> amenities;

    @ElementCollection
    private List<String> photos;

    private boolean available;

    public void markAsUnavailable() {
        this.available = false;
    }
}
