package com.example.demo.model;

import javax.persistence.*;

import java.util.List;

@Entity
@Table
public class Employee {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String birthday;
    private String cardId;
    private double salary;
    private String phone;
    private String email;
    private String address;

    @ManyToOne(targetEntity = Position.class)
    private Position position;

    @ManyToOne(targetEntity = Education_degree.class)
    private Education_degree education_degree;

    @ManyToOne(targetEntity = Division.class)
    private Division division;

    @OneToMany(mappedBy = "employee")
    private List<Contract> contracts;

    @ManyToOne(targetEntity = User.class)
    private User user;

    public Employee() {
    }

    public Employee(int id, String name, String birthday, String cardId, double salary, String phone, String email, String address) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.cardId = cardId;
        this.salary = salary;
        this.phone = phone;
        this.email = email;
        this.address = address;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
