/*
 * Copyright (c) 3/15/20, 10:36 PM. Mehdi 3/15/20, 10:28 PM
 */

package com.school.demo.model.data;

import com.school.demo.util.Constants;

import java.util.HashSet;
import java.util.Set;

public class LoginDetailsData {


    private Long id;

    private String username;

    private String email;

    private String password;

    private Set<Constants.ERole> roles = new HashSet<>();

    public LoginDetailsData() {
    }

    public LoginDetailsData(Long id, String username, String email, String password, Set<Constants.ERole> roles) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Constants.ERole> getRoles() {
        return roles;
    }

    public void setRoles(Set<Constants.ERole> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "LoginDetailsData{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", roles=" + roles +
                '}';
    }
}
