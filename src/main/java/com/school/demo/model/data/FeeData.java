/*
 * Copyright (c) 3/15/20, 10:36 PM. Mehdi 3/15/20, 10:31 PM
 */

package com.school.demo.model.data;

import com.school.demo.util.Constants;

import java.util.Date;

public class FeeData {


    private long id;


    private Constants.EFee feeCategory;

    private double amount;

    private boolean payed;

    private Date time;


    public FeeData() {
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

    @Override
    public String toString() {
        return "FeeData{" +
                "id=" + id +
                ", feeCategory=" + feeCategory +
                ", amount=" + amount +
                ", payed=" + payed +
                ", time=" + time +
                '}';
    }
}
