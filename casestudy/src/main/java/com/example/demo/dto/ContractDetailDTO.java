package com.example.demo.dto;

import com.example.demo.model.Attach_service;
import com.example.demo.model.Contract;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

public class ContractDetailDTO implements Serializable {
    private int id;
    private Contract contract;
    private Attach_service attach_service;
    @NotEmpty
    private int quantity;

    public ContractDetailDTO() {
    }

    public ContractDetailDTO(int id, Contract contract, Attach_service attach_service, int quantity) {
        this.id = id;
        this.contract = contract;
        this.attach_service = attach_service;
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
