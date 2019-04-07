package com.facility.domain.service;

import com.facility.domain.model.Facility;
import com.facility.domain.model.FacilityInformation;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class FacilityServiceTest {
    private FacilityService facilityService;

    @Before
    public void before() {
        facilityService = new FacilityService(new Facility(3),3);
    }

    @Test
    public void listFacilitiesTest() {
        facilityService.addNewFacility(new Facility(1));
        facilityService.addNewFacility(new Facility(1));
        facilityService.addNewFacility(new Facility(1));
        List facilities = facilityService.listFacilities();
        assertThat(facilities.size(), is(3));
    }

    @Test
    public void getFacilityInformationTest() {
        FacilityInformation facilityInformation = facilityService.getFacilityInformation();
        assertEquals(facilityInformation, facilityService.getFacilityInformation());
    }

    @Test
    public void requestAvailableCapacityTest() {
        facilityService.addNewFacility(new Facility(1));
        facilityService.addNewFacility(new Facility(2));
        facilityService.addNewFacility(new Facility(3));

        int capacity = facilityService.requestAvailableCapacity();
        assertThat(capacity, is(9));  //3 + 1 + 2 + 3
    }

    @Test
    public void addNewFacilityTest() {
        facilityService.addNewFacility(new Facility(1));
        assertThat(facilityService.getFacilities().size(), is(1));
    }

    @Test
    public void addFacilityDetailTest() {
        facilityService.addFacilityDetail("", "");
        assertThat(facilityService.getFacilityDetails().size(), is(1));
    }

    @Test
    public void removeFacilityTest() {
        Facility newFacility = new Facility(1);
        facilityService.addNewFacility(newFacility);
        assertThat(facilityService.getFacilities().size(), is(1));
        facilityService.removeFacility(newFacility);
        assertThat(facilityService.getFacilities().size(), is(0));
    }
}
