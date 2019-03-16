package com.facility.model;

import com.facility.model.interfaces.*;
import com.facility.model.*;
import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

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
        facilityObject.addFacilityDetail("", "");
        assertThat(facilityObject.getFacilityDetails().size(), is(1));
    }

    @Test
    public void removeFacilityTest() {
        Facility newFacility = new FacilityObject(1);
        facilityObject.addNewFacility(newFacility);
        assertThat(facilityObject.getFacilities().size(), is(1));
        facilityObject.removeFacility(newFacility);
        assertThat(facilityObject.getFacilities().size(), is(0));
    }

    @Test
    public void assignFacilityToUseTest() {
        facilityObject.assignFacilityToUse();
        assertThat(facilityObject.getStatus(), is(Status.IN_USE));
    }

    @Test
    public void vacateFacilityTest() {
        facilityObject.vacateFacility();
        assertThat(facilityObject.getStatus(), is(Status.FREE));
    }

    @Test
    public void listInspectionsTest() {
        facilityObject.listInspections();
    }

    @Test
    public void listActualUsageTest() {
        List<Usage> usages = facilityObject.listActualUsage();
        assertEquals(usages, facilityObject.getUsages());
    }

    @Test
    public void calcUsageRateNoUsageTest() {
        String result = facilityObject.calcUsageRate();
        assertThat(result, is("0"));
    }

    @Test
    public void calcUsageRateWithUsageTest() {
        facilityObject.getUsages().add(new Usage());
        facilityObject.getUsages().add(new Usage());
        facilityObject.getMaintenances().add(new Maintenance());
        String result = facilityObject.calcUsageRate();
        assertThat(result, is("66.67"));
    }

    @Test
    public void makeFacilityMaintRequestTest() {
        facilityObject.makeFacilityMaintRequest();
        assertThat(facilityObject.getMaintenanceRequests().size(), is(1));
    }

    @Test
    public void scheduleMaintenanceTest() {
        Date current = new Date();
        facilityObject.scheduleMaintenance(current);
        assertThat(facilityObject.getMaintenances().size(), is(1));
    }

    @Test
    public void calcMaintenanceCostForFacilityTest() {
        facilityObject.getMaintenances().add(new Maintenance(null, null, 3));
        facilityObject.getMaintenances().add(new Maintenance(null, null, 5));
        facilityObject.getMaintenances().add(new Maintenance(null, null, 5));
        int result = facilityObject.calcMaintenanceCostForFacility();
        assertThat(result, is(13));
    }

    @Test
    public void calcProblemRateForFacilityTest() {
        facilityObject.getInspections().add(new Inspection(null, true));
        facilityObject.getInspections().add(new Inspection(null, true));
        facilityObject.getInspections().add(new Inspection(null, true));
        facilityObject.getInspections().add(new Inspection(null, false));
        String result = facilityObject.calcProblemRateForFacility();
        assertThat(result, is("75.00"));
    }

    @Test
    public void listMaintRequestsTest() {
        List<MaintenanceRequest> maintenanceRequests = facilityObject.listMaintRequests();
        assertEquals(maintenanceRequests, facilityObject.getMaintenanceRequests());
    }

    @Test
    public void listMaintenanceTest() {
        List<Maintenance> maintenances = facilityObject.listMaintenance();
        assertEquals(maintenances, facilityObject.getMaintenances());
    }

    @Test
    public void listFacilityProblemsTest() {
        List<FacilityProblem> facilityProblems = facilityObject.listFacilityProblems();
        assertEquals(facilityProblems, facilityObject.getFacilityProblems());
    }

    @Test
    public void calcDownTimeForFacilityTest() {
        Date date = new Date();
        Calendar cal = Calendar.getInstance(); // creates calendar
        cal.setTime(date); // sets calendar time/date
        cal.add(Calendar.HOUR_OF_DAY, 5); // adds 5 hours
        Date datePlusFiveHours = cal.getTime();
        Maintenance maintenance = new Maintenance();
        maintenance.setStart(date);
        maintenance.setEnd(datePlusFiveHours);
        facilityObject.getMaintenances().add(maintenance);
        long result = facilityObject.calcDownTimeForFacility();
        assertThat(result, is(5L));
    }
}