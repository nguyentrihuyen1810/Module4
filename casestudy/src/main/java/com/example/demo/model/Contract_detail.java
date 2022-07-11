package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table
public class Contract_detail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(targetEntity = Contract.class)
    private Contract contract;

    @ManyToOne(targetEntity = Attach_service.class)
    private Attach_service attach_service;

    private int quantity;

    public Contract_detail() {
    }

    public Contract_detail(int id, int quantity) {
        this.id = id;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public Attach_service getAttach_service() {
        return attach_service;
    }

    public void setAttach_service(Attach_service attach_service) {
        this.attach_service = attach_service;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
