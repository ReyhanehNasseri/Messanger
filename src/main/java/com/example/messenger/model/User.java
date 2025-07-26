package com.example.messenger.model;

import jakarta.persistence.*;

import java.util.UUID;


@Entity
@Table
public class User {
    @Id
    @Column
    private String id = UUID.randomUUID().toString();
    private String name;
    @Column(unique = true)
    private String email;


    public User(String email, String name) {
        this.email = email;
        this.name = name;
    }

    public User() {

    }

    public String getId() {
        return id;
    }

    public void setId (String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
}


