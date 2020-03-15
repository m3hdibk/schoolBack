/*
 * Copyright (c) 3/15/20, 10:36 PM. Mehdi 3/15/20, 10:23 PM
 */

package com.school.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.school.demo.util.Constants;
import com.school.demo.util.converter.UserRolesConverter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(	name = "loginDetails",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "username"),
                @UniqueConstraint(columnNames = "email")
        })
public class LoginDetails implements Serializable {
    private static final long serialVersionUID = -7058795925583015579L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 20)
    private String username;

    @NotBlank
    @Size(max = 50)
    @Email
    private String email;

    @NotBlank
    @Size(max = 120)
    @JsonIgnore
    private String password;


    @ElementCollection(targetClass = Constants.ERole.class)
    @JoinTable(	name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "enumValues", nullable = false)
    @Convert(converter = UserRolesConverter.class)
    private Set<Constants.ERole> roles = new HashSet<>();

    public LoginDetails() {
    }

    public LoginDetails(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
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
}
