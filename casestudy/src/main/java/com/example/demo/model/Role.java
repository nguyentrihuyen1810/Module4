package com.example.demo.model;


import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Role {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @OneToMany(mappedBy = "role")
    private List<User_role> user_roles;

    public Role() {
    }

    public Role(int id, String name, List<User_role> user_roles) {
        this.id = id;
        this.name = name;
        this.user_roles = user_roles;
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

    public List<User_role> getUser_roles() {
        return user_roles;
    }

    public void setUser_roles(List<User_role> user_roles) {
        this.user_roles = user_roles;
    }
}
