package com.bengriner.geocoding.model;

public class Address {
    private String streetAddress, city, state, zipCode;

    public Address(String streetAddress, String city, String state, String zipCode) {
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String toString() {
        if (this.streetAddress == null || this.streetAddress.isEmpty()) {
            this.streetAddress = "";
        }
        if (this.city == null || this.city.isEmpty()) {
            this.city = "";
        }
        if (this.state == null || this.state.isEmpty()) {
            this.state = "";
        }
        if (this.zipCode == null || this.zipCode.isEmpty()) {
            this.zipCode = "";
        }
        return this.streetAddress + ", " + this.city + ", " + this.state + ", " + this.zipCode;
    }
}
