package com.example.demo.model;

import javax.persistence.*;

import java.util.List;

@Entity
@Table
public class Customer {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(targetEntity = Customer_type.class)
    private Customer_type customer_type;

    @OneToMany(mappedBy = "customer")
    private List<Contract> contracts;

    private String name;
    private String birthday;
    private String gender;
    private String cardId;
    private String phone;
    private String email;
    private String address;

    public Customer() {
    }

    public Customer(int id, String name, String birthday, String gender, String cardId, String phone, String email, String address) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.cardId = cardId;
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

    public Customer_type getCustomer_type() {
        return customer_type;
    }

    public void setCustomer_type(Customer_type customer_type) {
        this.customer_type = customer_type;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
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

    public List<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(List<Contract> contracts) {
        this.contracts = contracts;
    }
}
