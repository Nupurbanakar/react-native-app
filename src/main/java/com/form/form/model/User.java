package com.form.form.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Generated;

@Entity
@Data
public class User {
    @Id
    @Generated
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String username;
    private String password;

    public User() {}

    public User(Long id, String name, String email, String phone, String username, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.username = username;
        this.password = password;
    }

}
