package com.anirudh.advertiserservice.model;




public class Advertiser {

    private String advertiserName;
    private String contactName;
    private int creditLimit;

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

    public int getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(int creditLimit) {
        this.creditLimit = creditLimit;
    }




}
