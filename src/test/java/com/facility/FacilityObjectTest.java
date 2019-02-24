package com.facility;

import com.facility.interfaces.Facility;
import com.facility.model.FacilityObject;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class FacilityObjectTest {

    private FacilityObject facilityObject;

    @Before
    public void before() {
        facilityObject = new FacilityObject(3);
    }

    @Test
    public void listFacilitiesTest() {
        facilityObject.addNewFacility(new FacilityObject(1));
        facilityObject.addNewFacility(new FacilityObject(1));
        facilityObject.addNewFacility(new FacilityObject(1));
        List facilities = facilityObject.listFacilities();
        assertThat(facilities.size(), is(3));
    }

    @Test
    public void getFacilityInformationTest() {
        Facility facility = facilityObject.getFacilityInformation();
        assertEquals(facility, facilityObject);
    }

    @Test
    public void requestAvailableCapacityTest() {
        facilityObject.addNewFacility(new FacilityObject(1));
        facilityObject.addNewFacility(new FacilityObject(2));
        facilityObject.addNewFacility(new FacilityObject(3));

        int capacity = facilityObject.requestAvailableCapacity();
        assertThat(capacity, is(9));  //3 + 1 + 2 + 3
    }

    @Test
    public void addNewFacilityTest() {
        facilityObject.addNewFacility(new FacilityObject(1));
        assertThat(facilityObject.getFacilities().size(), is(1));
    }

    @Test
    public void addFacilityDetailTest() {
    }

    @Test
    public void removeFacilityTest() {
    }

    @Test
    public void isInUseDuringIntervalTest() {
    }

    @Test
    public void assignFacilityToUseTest() {
    }

    @Test
    public void vacateFacilityTest() {
    }

    @Test
    public void listInspectionsTest() {
    }

    @Test
    public void listActualUsageTest() {
    }

    @Test
    public void calcUsageRateTest() {
    }

    @Test
    public void makeFacilityMaintRequestTest() {
    }

    @Test
    public void scheduleMaintenanceTest() {
    }

    @Test
    public void calcMaintenanceCostForFacilityTest() {
    }

    @Test
    public void calcProblemRateForFacilityTest() {
    }

    @Test
    public void calcDownTimeForFacilityTest() {
    }

    @Test
    public void listMaintRequestsTest() {
    }

    @Test
    public void listMaintenanceTest() {
    }

    @Test
    public void listFacilityProblemsTest() {
    }
}