package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table
public class User {
    @Id
    private String username;
    private String password;

    @OneToMany(mappedBy = "user")
    private List<Employee> employees;

    @OneToMany(mappedBy = "user")
    private List<User_role> user_roles;

    public User() {
    }

    public User(String username, String password, List<Employee> employees) {
        this.username = username;
        this.password = password;
        this.employees = employees;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
