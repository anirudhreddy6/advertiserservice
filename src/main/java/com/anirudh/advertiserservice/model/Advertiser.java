package com.anirudh.advertiserservice.model;


import lombok.*;

import javax.validation.constraints.NotNull;


@Getter@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Advertiser {

    @NotNull
    private String advertiserName;
    @NotNull
    private String contactName;
    private double creditLimit;

/*
    public Advertiser(String advertiserName, String contactName, double creditLimit) {
        this.advertiserName = advertiserName;
        this.contactName = contactName;
        this.creditLimit = creditLimit;
    }
    public Advertiser()
    {

    }



    public String getAdvertiserName() {
        return advertiserName;
    }
    public void setAdvertiserName(String advertiserName) {
        this.advertiserName = advertiserName;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public double getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(double creditLimit) {
        this.creditLimit = creditLimit;
    }


    */




}
