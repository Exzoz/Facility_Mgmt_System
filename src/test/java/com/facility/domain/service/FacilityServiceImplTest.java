package com.facility.domain.service;

import com.facility.domain.model.Facility;
import com.facility.domain.model.FacilityInformation;
import com.facility.domain.service.impl.FacilityServiceImpl;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class FacilityServiceImplTest {
    private FacilityServiceImpl facilityServiceImpl;

    @Before
    public void before() {
        facilityServiceImpl = new FacilityServiceImpl(new Facility(3));
    }

    @Test
    public void listFacilitiesTest() {
        facilityServiceImpl.addNewFacility(new Facility(1));
        facilityServiceImpl.addNewFacility(new Facility(1));
        facilityServiceImpl.addNewFacility(new Facility(1));
        List facilities = facilityServiceImpl.listFacilities();
        assertThat(facilities.size(), is(3));
    }

    @Test
    public void getFacilityInformationTest() {
        FacilityInformation facilityInformation = facilityServiceImpl.getFacilityInformation();
        assertEquals(facilityInformation, facilityServiceImpl.getFacilityInformation());
    }

    @Test
    public void requestAvailableCapacityTest() {
        facilityServiceImpl.addNewFacility(new Facility(1));
        facilityServiceImpl.addNewFacility(new Facility(2));
        facilityServiceImpl.addNewFacility(new Facility(3));

        int capacity = facilityServiceImpl.requestAvailableCapacity();
        assertThat(capacity, is(9));  //3 + 1 + 2 + 3
    }

    @Test
    public void addNewFacilityTest() {
        facilityServiceImpl.addNewFacility(new Facility(1));
        assertThat(facilityServiceImpl.getFacilities().size(), is(1));
    }

    @Test
    public void addFacilityDetailTest() {
        facilityServiceImpl.addFacilityDetail("", "");
        assertThat(facilityServiceImpl.getFacilityDetails().size(), is(1));
    }

    @Test
    public void removeFacilityTest() {
        Facility newFacility = new Facility(1);
        facilityServiceImpl.addNewFacility(newFacility);
        assertThat(facilityServiceImpl.getFacilities().size(), is(1));
        facilityServiceImpl.removeFacility(newFacility);
        assertThat(facilityServiceImpl.getFacilities().size(), is(0));
    }
}
