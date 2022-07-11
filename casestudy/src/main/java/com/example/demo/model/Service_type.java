package com.example.demo.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Service_type {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @OneToMany(mappedBy = "service_type")
    private List<Service> services;

    public Service_type() {
    }

    public Service_type(int id, String name) {
        this.id = id;
        this.name = name;
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
}
