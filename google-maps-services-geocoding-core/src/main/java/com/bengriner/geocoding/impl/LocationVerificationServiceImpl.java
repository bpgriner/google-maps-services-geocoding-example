package com.bengriner.geocoding.impl;

import com.bengriner.geocoding.LocationVerificationService;
import com.bengriner.geocoding.model.Address;
import com.bengriner.geocoding.model.GpsLocation;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.model.GeocodingResult;
import com.google.maps.model.LatLng;

import java.util.concurrent.TimeUnit;

public class LocationVerificationServiceImpl implements LocationVerificationService {
    private static GeoApiContext context;

    public LocationVerificationServiceImpl() {
        context = new GeoApiContext()
                .setApiKey("AIzaSyBSFlNij8fw5oWmLjgweHtPSrhU_RLaxYk")
                .setQueryRateLimit(3)
                .setConnectTimeout(1, TimeUnit.SECONDS)
                .setReadTimeout(1, TimeUnit.SECONDS)
                .setWriteTimeout(1, TimeUnit.SECONDS);
    }


    /* -------------------------- */
    /*  Public interface methods  */
    /* -------------------------- */

    public boolean verifyMatch(GpsLocation gpsLocation, Address address) {
        boolean verifiedMatch = false;

        if (gpsLocation == null) {
            throw new NullPointerException("GpsLocation object is null.");
        } else if (address == null) {
            throw new NullPointerException("Address object is null.");
        } else if (!isValid(address)) {
            throw new RuntimeException("Address object elements are invalid.");
        }

        GpsLocation standardizedGpsLocation = getStandardizedGpsLocation(gpsLocation);
        GpsLocation gpsLocationOfAddress = getGpsLocation(address);

        if (standardizedGpsLocation != null && gpsLocationOfAddress != null) {
            if (standardizedGpsLocation.getLatitude() == gpsLocationOfAddress.getLatitude()
                    && standardizedGpsLocation.getLongitude() == gpsLocationOfAddress.getLongitude()) {
                verifiedMatch = true;
            }
        }
        return verifiedMatch;
    }


    /* ------------------------- */
    /*      Private methods      */
    /* ------------------------- */

    private boolean isValid(Address address) {
        boolean isValid = false;
        if (address != null) {
            // Street Address and City are required fields
            if (address.getStreetAddress() != null && address.getCity() != null) {
                // State or Zip Code need to be present, but both are not required
                if (address.getState() != null || address.getZipCode() != null) {
                    isValid = true;
                }
            }
        }
        return isValid;
    }

    private GpsLocation getStandardizedGpsLocation(GpsLocation gpsLocation) {
        try {
            LatLng latLng = new LatLng(gpsLocation.getLatitude(), gpsLocation.getLongitude());
            GeocodingResult[] results = GeocodingApi.reverseGeocode(context, latLng).await();
            GeocodingResult result = results[0];
            if (result != null) {
                String address = result.formattedAddress;
                return getGpsLocation(address);
            }

        } catch (java.lang.Exception e) {
            throw new RuntimeException("Geocoding API communication failure inside getStandardizedGpsLocation()");
        }
        return null;
    }

    private GpsLocation getGpsLocation(Address address) {
        return getGpsLocation(address.toString());
    }

    private GpsLocation getGpsLocation(String address) {
        try {
            GeocodingResult[] results = GeocodingApi.geocode(context, address).await();
            GeocodingResult result = results[0];
            if (result != null && result.geometry != null && result.geometry.location != null) {
                LatLng latLng = result.geometry.location;
                return new GpsLocation(latLng.lat,latLng.lng);
            }

        } catch (java.lang.Exception e) {
            throw new RuntimeException("Geocoding API communication failure inside getGpsLocation()");
        }
        return null;
    }
}
