package com.anirudh.advertiserservice.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class Advertiser {

    @NotNull
    private String advertiserName;
    @NotNull
    private String contactName;
    private double creditLimit;


    public Advertiser(String advertiserName, String contactName, int creditLimit) {
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

    public void setCreditLimit(int creditLimit) {
        this.creditLimit = creditLimit;
    }




}
