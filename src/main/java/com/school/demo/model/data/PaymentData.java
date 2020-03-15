/*
 * Copyright (c) 3/15/20, 10:36 PM. Mehdi 3/15/20, 10:23 PM
 */

package com.school.demo.model.data;


import com.school.demo.model.Fee;
import com.school.demo.model.LoginDetails;

import java.util.Set;

public class PaymentData {


    private long id;

    private double feesToPay;

    private Set<Fee> fees;

    private LoginDetails user;


    public PaymentData() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getFeesToPay() {
        return feesToPay;
    }

    public void setFeesToPay(double feesToPay) {
        this.feesToPay = feesToPay;
    }

    public Set<Fee> getFees() {
        return fees;
    }

    public void setFees(Set<Fee> fees) {
        this.fees = fees;
    }

    public LoginDetails getUser() {
        return user;
    }

    public void setUser(LoginDetails user) {
        this.user = user;
    }


}
