package com.anirudh.advertiserservice.model;

import lombok.*;

@Getter@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Advertiser {

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

    private String advertiserName;
    private String contactName;
    private double creditLimit;





}
