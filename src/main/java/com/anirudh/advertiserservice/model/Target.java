package com.anirudh.advertiserservice.model;

public class Target {


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAreacode() {
        return areacode;
    }

    public void setAreacode(String areacode) {
        this.areacode = areacode;
    }

    public Target(String name, String areacode) {
        this.name = name;
        this.areacode = areacode;
    }

    private String name;
    private String areacode;


}
