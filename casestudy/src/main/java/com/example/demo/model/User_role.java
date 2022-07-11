package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table
public class User_role {
    @Id
    private int id;

    @ManyToOne(targetEntity = Role.class)
    private Role role;

    @ManyToOne(targetEntity = User.class)
    private User user;

    public User_role() {
    }

    public User_role(Role role, User user) {
        this.role = role;
        this.user = user;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
