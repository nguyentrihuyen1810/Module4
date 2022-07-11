package com.example.demo.model;

import javax.persistence.*;

import java.util.List;

@Entity
@Table
public class Rent_type {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private double cost;

    @OneToMany(mappedBy = "rent_type")
    private List<Service> services;

    public Rent_type() {
    }

    public Rent_type(int id, String name, double cost) {
        this.id = id;
        this.name = name;
        this.cost = cost;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}
