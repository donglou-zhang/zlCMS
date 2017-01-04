package com.cms.zl.entity;

import org.springframework.context.annotation.Role;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

/**
 * Created by Vincent on 2016/12/15.
 */
@Entity
public class User extends ParentEntity{

    @Column(nullable = false, unique = true, length = 12)
    private String username;

    @Column(nullable = false, length = 64)
    private String password;

    @Column(nullable = false, length = 12)
    private String role;

    public User() {
        role = "user";
    }

    public User(String username, String password) {
        role = "user";
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
