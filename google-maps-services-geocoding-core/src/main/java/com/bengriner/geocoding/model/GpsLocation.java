package com.bengriner.geocoding.model;

public class GpsLocation {
    private double latitude,longitude;

    public GpsLocation(double latitude, double longitude){
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }
}
