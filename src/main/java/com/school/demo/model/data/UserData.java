/*
 * Copyright (c) 3/15/20, 10:36 PM. Mehdi 3/15/20, 10:36 PM
 */

package com.school.demo.model.data;

import com.school.demo.model.LoginDetails;

import java.time.LocalDate;

public class UserData {


    private long id;

    private String firstName;

    private String lastName;

    private LocalDate birthDate;

    private LoginDetails loginDetails;


    public UserData() {}

    public UserData(long id, String firstName, String lastName, LocalDate birthDate, LoginDetails loginDetails) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.loginDetails = loginDetails;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public LoginDetails getLoginDetails() {
        return loginDetails;
    }

    public void setLoginDetails(LoginDetails loginDetails) {
        this.loginDetails = loginDetails;
    }

    @Override
    public String toString() {
        return "UserData{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                ", loginDetails=" + loginDetails +
                '}';
    }
}
