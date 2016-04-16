package com.bengriner.geocoding.impl;

import com.bengriner.geocoding.LocationVerificationService;
import com.bengriner.geocoding.model.Address;
import com.bengriner.geocoding.model.GpsLocation;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Creation Date: 4/15/16
 */
public class LocationVerificationServiceImplIntegrationTest {
    private static LocationVerificationService locationVerificationService;
    private static GpsLocation dellzUptownGpsLocation1, dellzUptownGpsLocation2, dellzUptownGpsLocation3;
    private static Address dellzUptownAddress1, dellzUptownAddress2, dellzUptownAddress3, dellzUptownAddress4,
            dellzUptownAddress5;

    @BeforeClass
    public static void oneTimeSetup() {
        locationVerificationService = new LocationVerificationServiceImpl();

        /* Longitude and Latitude values from clicking on Dellz Uptown's property in Google Maps */
        dellzUptownGpsLocation1 = new GpsLocation(32.793362,-79.949008);
        dellzUptownGpsLocation2 = new GpsLocation(32.793418,-79.949020);
        dellzUptownGpsLocation3 = new GpsLocation(32.793383,-79.948937);

        /* Different combinations of Dellz Uptown's address */
        dellzUptownAddress1 = new Address("511 Rutledge Ave", "Charleston", "SC", "29403");
        dellzUptownAddress2 = new Address("511 Rutledge Avenue", "Chas", "SC", "29403");
        dellzUptownAddress3 = new Address("511 Rutledge Avenue", "Charleston", "South Carolina", "29403");
        dellzUptownAddress4 = new Address("511 Rutledge Ave", "Charleston", null, "29403");
        dellzUptownAddress5 = new Address("511 Rutledge Ave", "Charleston", "SC", null);
    }

    @Test
    public void testVerifyMatch_dellzUptownGpsLocation1_dellzUptownAddress1_good() {
        assertTrue(locationVerificationService.verifyMatch(dellzUptownGpsLocation1, dellzUptownAddress1));
    }

    @Test
    public void testVerifyMatch_dellzUptownGpsLocation1_dellzUptownAddress2_good() {
        assertTrue(locationVerificationService.verifyMatch(dellzUptownGpsLocation1, dellzUptownAddress2));
    }

    @Test
    public void testVerifyMatch_dellzUptownGpsLocation1_dellzUptownAddress3_good() {
        assertTrue(locationVerificationService.verifyMatch(dellzUptownGpsLocation1, dellzUptownAddress3));
    }

    @Test
    public void testVerifyMatch_dellzUptownGpsLocation1_dellzUptownAddress4_good() {
        assertTrue(locationVerificationService.verifyMatch(dellzUptownGpsLocation1, dellzUptownAddress4));
    }

    @Test
    public void testVerifyMatch_dellzUptownGpsLocation1_dellzUptownAddress5_good() {
        assertTrue(locationVerificationService.verifyMatch(dellzUptownGpsLocation1, dellzUptownAddress5));
    }

    @Test
    public void testVerifyMatch_dellzUptownGpsLocation2_dellzUptownAddress1_good() {
        assertTrue(locationVerificationService.verifyMatch(dellzUptownGpsLocation2, dellzUptownAddress1));
    }

    @Test
    public void testVerifyMatch_dellzUptownGpsLocation2_dellzUptownAddress2_good() {
        assertTrue(locationVerificationService.verifyMatch(dellzUptownGpsLocation2, dellzUptownAddress2));
    }

    @Test
    public void testVerifyMatch_dellzUptownGpsLocation2_dellzUptownAddress3_good() {
        assertTrue(locationVerificationService.verifyMatch(dellzUptownGpsLocation2, dellzUptownAddress3));
    }

    @Test
    public void testVerifyMatch_dellzUptownGpsLocation2_dellzUptownAddress4_good() {
        assertTrue(locationVerificationService.verifyMatch(dellzUptownGpsLocation2, dellzUptownAddress4));
    }

    @Test
    public void testVerifyMatch_dellzUptownGpsLocation2_dellzUptownAddress5_good() {
        assertTrue(locationVerificationService.verifyMatch(dellzUptownGpsLocation2, dellzUptownAddress5));
    }

    @Test
    public void testVerifyMatch_dellzUptownGpsLocation3_dellzUptownAddress1_good() {
        assertTrue(locationVerificationService.verifyMatch(dellzUptownGpsLocation3, dellzUptownAddress1));
    }

    @Test
    public void testVerifyMatch_dellzUptownGpsLocation3_dellzUptownAddress2_good() {
        assertTrue(locationVerificationService.verifyMatch(dellzUptownGpsLocation3, dellzUptownAddress2));
    }

    @Test
    public void testVerifyMatch_dellzUptownGpsLocation3_dellzUptownAddress3_good() {
        assertTrue(locationVerificationService.verifyMatch(dellzUptownGpsLocation3, dellzUptownAddress3));
    }

    @Test
    public void testVerifyMatch_dellzUptownGpsLocation3_dellzUptownAddress4_good() {
        assertTrue(locationVerificationService.verifyMatch(dellzUptownGpsLocation3, dellzUptownAddress4));
    }

    @Test
    public void testVerifyMatch_dellzUptownGpsLocation3_dellzUptownAddress5_good() {
        assertTrue(locationVerificationService.verifyMatch(dellzUptownGpsLocation3, dellzUptownAddress5));
    }
}
