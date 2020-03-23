package org.allsafeclinic.hospital.administration.entity;

import javax.persistence.Embeddable;

@Embeddable
public class Address {


    private String houseName;
    private String streetName;
    private String place;

    private String city;

    private String state;

    private String pinCode;

    public Address(String houseName, String streetName, String place, String city, String state, String pinCode) {
        this.houseName = houseName;
        this.streetName = streetName;
        this.place = place;
        this.city = city;
        this.state = state;
        this.pinCode = pinCode;
    }

    public Address() {

    }

    public String getHouseName() {
        return houseName;
    }

    public void setHouseName(String houseName) {
        this.houseName = houseName;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }
}