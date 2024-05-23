
package com.example.demo.model;
import jakarta.persistence.*;



@Entity
public class Venue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name; // Add this property

    // Other properties, constructors, getters, and setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}