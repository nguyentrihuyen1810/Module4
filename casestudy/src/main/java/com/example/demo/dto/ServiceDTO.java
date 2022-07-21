package com.example.demo.dto;

import com.example.demo.model.Contract;
import com.example.demo.model.Rent_type;
import com.example.demo.model.Service_type;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.List;

public class ServiceDTO implements Serializable {
    private int id;
    @NotEmpty
    private String name;
    private int area;
    private double cost;
    private int maxPeople;
    private Service_type service_type;
    private Rent_type rent_type;
    private List<Contract> contracts;
    @NotEmpty
    private String standardRoom;
    @NotEmpty
    private String descriptionOtherConvenience;
    private double poolArea;
    private int numberOfFloors;

    public ServiceDTO() {
    }

    public ServiceDTO(int id, String name, int area, double cost, int maxPeople, Service_type service_type, Rent_type rent_type, List<Contract> contracts, String standardRoom, String descriptionOtherConvenience, double poolArea, int numberOfFloors) {
        this.id = id;
        this.name = name;
        this.area = area;
        this.cost = cost;
        this.maxPeople = maxPeople;
        this.service_type = service_type;
        this.rent_type = rent_type;
        this.contracts = contracts;
        this.standardRoom = standardRoom;
        this.descriptionOtherConvenience = descriptionOtherConvenience;
        this.poolArea = poolArea;
        this.numberOfFloors = numberOfFloors;
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

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(int maxPeople) {
        this.maxPeople = maxPeople;
    }

    public Service_type getService_type() {
        return service_type;
    }

    public void setService_type(Service_type service_type) {
        this.service_type = service_type;
    }

    public Rent_type getRent_type() {
        return rent_type;
    }

    public void setRent_type(Rent_type rent_type) {
        this.rent_type = rent_type;
    }

    public List<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(List<Contract> contracts) {
        this.contracts = contracts;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getDescriptionOtherConvenience() {
        return descriptionOtherConvenience;
    }

    public void setDescriptionOtherConvenience(String descriptionOtherConvenience) {
        this.descriptionOtherConvenience = descriptionOtherConvenience;
    }

    public double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(double poolArea) {
        this.poolArea = poolArea;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }
}
