package com.facility.domain.service;

import com.facility.domain.model.*;
import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class FacilityMaintenanceServiceTest {
    private FacilityMaintenanceService facilityMaintenanceService;

    @Before
    public void before() {
        facilityMaintenanceService = new FacilityMaintenanceService(new Facility(3));
    }

    @Test
    public void listInspectionsTest() {
        facilityMaintenanceService.listInspections();
    }

    @Test
    public void makeFacilityMaintRequestTest() {
        facilityMaintenanceService.makeFacilityMaintRequest();
        assertThat(facilityMaintenanceService.getMaintenanceRequests().size(), is(1));
    }

    @Test
    public void scheduleMaintenanceTest() {
        Date current = new Date();
        facilityMaintenanceService.scheduleMaintenance(current);
        assertThat(facilityMaintenanceService.getMaintenances().size(), is(1));
        assertEquals(facilityMaintenanceService.getMaintenances().get(0).getStart(), current);
    }

    @Test
    public void calcMaintenanceCostForFacilityTest() {
        facilityMaintenanceService.getMaintenances().add(new Maintenance(null, null, 3));
        facilityMaintenanceService.getMaintenances().add(new Maintenance(null, null, 5));
        facilityMaintenanceService.getMaintenances().add(new Maintenance(null, null, 5));
        int result = facilityMaintenanceService.calcMaintenanceCostForFacility();
        assertThat(result, is(13));
    }

    @Test
    public void calcProblemRateForFacilityTest() {
        facilityMaintenanceService.getInspections().add(new Inspection(null, true));
        facilityMaintenanceService.getInspections().add(new Inspection(null, true));
        facilityMaintenanceService.getInspections().add(new Inspection(null, true));
        facilityMaintenanceService.getInspections().add(new Inspection(null, false));
        String result = facilityMaintenanceService.calcProblemRateForFacility();
        assertThat(result, is("75.00"));
    }

    @Test
    public void listMaintRequestsTest() {
        List<MaintenanceRequest> maintenanceRequests = facilityMaintenanceService.listMaintRequests();
        assertEquals(maintenanceRequests, facilityMaintenanceService.getMaintenanceRequests());
    }

    @Test
    public void listMaintenanceTest() {
        List<Maintenance> maintenances = facilityMaintenanceService.listMaintenance();
        assertEquals(maintenances, facilityMaintenanceService.getMaintenances());
    }

    @Test
    public void listFacilityProblemsTest() {
        List<FacilityProblem> facilityProblems = facilityMaintenanceService.listFacilityProblems();
        assertEquals(facilityProblems, facilityMaintenanceService.getFacilityProblems());
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
        facilityMaintenanceService.getMaintenances().add(maintenance);
        long result = facilityMaintenanceService.calcDownTimeForFacility();
        assertThat(result, is(5L));
    }
}
