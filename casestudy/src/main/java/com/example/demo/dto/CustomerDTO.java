package com.example.demo.dto;

import com.example.demo.model.Contract;
import com.example.demo.model.Customer_type;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

public class CustomerDTO implements Serializable {
    private int id;
    private Customer_type customer_type;
    private Contract contract;
    @NotEmpty
    private String name;
    @NotEmpty
    private String birthday;
    @NotEmpty
    private String gender;
    @NotEmpty
    private String cardId;
    @NotEmpty
    private String phone;
    @NotEmpty
    private String email;
    @NotEmpty
    private String address;

    public CustomerDTO() {
    }

    public CustomerDTO(int id, Customer_type customer_type, Contract contract, String name, String birthday, String gender, String cardId, String phone, String email, String address) {
        this.id = id;
        this.customer_type = customer_type;
        this.contract = contract;
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

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
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
}
