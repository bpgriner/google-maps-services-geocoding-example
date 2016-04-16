package com.bengriner.geocoding;

import com.bengriner.geocoding.model.GpsLocation;
import com.bengriner.geocoding.model.Address;

public interface LocationVerificationService {
    boolean verifyMatch(GpsLocation gpsLocation, Address address);
}
