/*
 * Copyright (c) 3/15/20, 10:36 PM. Mehdi 3/15/20, 10:23 PM
 */

package com.school.demo.model;


import com.school.demo.util.Constants;
import com.school.demo.util.converter.FeeCategoryConverter;
import javassist.SerialVersionUID;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "fees")
public class Fee implements Serializable {
    private static final long serialVersionUID = -1920735930717338291L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @Convert(converter = FeeCategoryConverter.class)
    private Constants.EFee feeCategory;

    private double amount;

    private boolean payed;

    private Date time;

    public Fee() {
    }

    public Fee(Constants.EFee feeCategory, double amount, boolean payed, Date time) {
        this.feeCategory = feeCategory;
        this.amount = amount;
        this.payed = payed;
        this.time = time;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Constants.EFee getFeeCategory() {
        return feeCategory;
    }

    public void setFeeCategory(Constants.EFee feeCategory) {
        this.feeCategory = feeCategory;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public boolean isPayed() {
        return payed;
    }

    public void setPayed(boolean payed) {
        this.payed = payed;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
