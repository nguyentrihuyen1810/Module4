package com.example.demo.dto;

import com.example.demo.model.Division;
import com.example.demo.model.Education_degree;
import com.example.demo.model.Position;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

public class EmployeeDTO implements Serializable {
    private int id;
    @NotEmpty
    private String name;
    @NotEmpty
    private String birthday;
    @NotEmpty
    private String cardId;
    @NotEmpty
    private double salary;
    @NotEmpty
    private String phone;
    @NotEmpty
    private String email;
    @NotEmpty
    private String address;
    private Position position;
    private Education_degree education_degree;
    private Division division;

    public EmployeeDTO() {
    }

    public EmployeeDTO(int id, String name, String birthday, String cardId, double salary, String phone, String email,
                       String address, Position position, Education_degree education_degree, Division division) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.cardId = cardId;
        this.salary = salary;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.position = position;
        this.education_degree = education_degree;
        this.division = division;
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

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Education_degree getEducation_degree() {
        return education_degree;
    }

    public void setEducation_degree(Education_degree education_degree) {
        this.education_degree = education_degree;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }
}
