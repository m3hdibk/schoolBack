/*
 * Copyright (c) 3/15/20, 10:36 PM. Mehdi 2/27/20, 4:31 PM
 */

package com.school.demo.security.payload.request;

import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

import javax.validation.constraints.*;
 
public class SignupRequest {
    @NotBlank
    @Size(min = 3, max = 20)
    private String username;
 
    @NotBlank
    @Size(max = 50)
    @Email
    private String email;
    
    private Set<Integer> role;
    
    @NotBlank
    @Size(min = 6, max = 40)
    private String password;

    private String firstName;

    private String lastName;

    private LocalDate brthDate;
  
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
    
    public Set<Integer> getRole() {
      return this.role;
    }
    
    public void setRole(Set<Integer> role) {
      this.role = role;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBrthDate() {
        return brthDate;
    }

    public void setBrthDate(LocalDate brthDate) {
        this.brthDate = brthDate;
    }
}
