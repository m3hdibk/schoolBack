/*
 * Copyright (c) 3/15/20, 10:36 PM. Mehdi 3/15/20, 10:23 PM
 */

package com.school.demo.model;


import com.school.demo.model.data.PaymentData;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;


@Entity
@Table(name = "payments")
public class Payment implements Serializable {

    private static final long serialVersionUID = -2132083274139886127L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private double feesToPay;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "fees_id")
    private Set<Fee> fees;

    @ManyToOne()
    @JoinColumn(name = "loginDetails_id")
    private LoginDetails user;

    public Payment() {
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

    public PaymentData convertToDataObject() {
        PaymentData paymentData = new PaymentData();
        paymentData.setId(this.id);
        paymentData.setFees(this.fees);
        paymentData.setFeesToPay(this.feesToPay);
        paymentData.setUser(this.user);
        return paymentData;
    }
}
