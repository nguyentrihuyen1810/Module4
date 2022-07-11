package com.example.demo.model;

import javax.persistence.*;

import java.util.List;

@Entity
@Table
public class Attach_service {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private double cost;
    private int unit;
    private String status;

    @OneToMany(mappedBy = "attach_service")
    private List<Contract_detail> contract_details;

    public Attach_service() {
    }

    public Attach_service(int id, String name, double cost, int unit, String status) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.unit = unit;
        this.status = status;
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

    public int getUnit() {
        return unit;
    }

    public void setUnit(int unit) {
        this.unit = unit;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Contract_detail> getContract_details() {
        return contract_details;
    }

    public void setContract_details(List<Contract_detail> contract_details) {
        this.contract_details = contract_details;
    }
}
