package com.bengriner.geocoding;

import com.bengriner.geocoding.impl.LocationVerificationServiceImpl;
import com.bengriner.geocoding.model.Address;
import com.bengriner.geocoding.model.GpsLocation;

public class Controller {

    public static void main(String [] args) {

        /* Imagine getting a user's GPS Location via a phone, tablet, or laptop */
        GpsLocation usersLocation = new GpsLocation(32.793418,-79.949020);

        /* And then, you may want to see if that user is at a specific address */
        Address dellzUptownAddress = new Address("511 Rutledge Ave", "Charleston", "SC", "29403");

        /*
         * You can now use the LocationVerificationService (which uses the Google Maps Geocoding API on the backend)
         * to verify if the user's GPS coordinates fall inside the given Address
         */
        LocationVerificationService locationVerificationService = new LocationVerificationServiceImpl();

        System.out.println("Checking to see if user's GPS Coordinates [" + usersLocation.getLatitude() + ", "
                + usersLocation.getLongitude() + "] fall inside this address: [" + dellzUptownAddress.toString() + "]");

        /* Make the call */
        boolean verfication = locationVerificationService.verifyMatch(usersLocation, dellzUptownAddress);

        /* Result should be true */
        System.out.println("Result from LocationVerificationService: " + verfication);
    }
}
