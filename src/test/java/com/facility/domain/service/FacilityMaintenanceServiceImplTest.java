package com.facility.domain.service;

import com.facility.domain.model.*;
import com.facility.domain.service.impl.FacilityMaintenanceImpl;
import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class FacilityMaintenanceServiceImplTest {
    private FacilityMaintenanceImpl facilityMaintenanceServiceImpl;

    @Before
    public void before() {
        facilityMaintenanceServiceImpl = new FacilityMaintenanceImpl(new Facility(3));
    }

    @Test
    public void listInspectionsTest() {
        facilityMaintenanceServiceImpl.listInspections();
    }

    @Test
    public void makeFacilityMaintRequestTest() {
        facilityMaintenanceServiceImpl.makeFacilityMaintRequest();
        assertThat(facilityMaintenanceServiceImpl.getMaintenanceRequests().size(), is(1));
    }

    @Test
    public void scheduleMaintenanceTest() {
        Date current = new Date();
        facilityMaintenanceServiceImpl.scheduleMaintenance(current);
        assertThat(facilityMaintenanceServiceImpl.getMaintenances().size(), is(1));
        assertEquals(facilityMaintenanceServiceImpl.getMaintenances().get(0).getStart(), current);
    }

    @Test
    public void calcMaintenanceCostForFacilityTest() {
        facilityMaintenanceServiceImpl.getMaintenances().add(new Maintenance(null, null, 3));
        facilityMaintenanceServiceImpl.getMaintenances().add(new Maintenance(null, null, 5));
        facilityMaintenanceServiceImpl.getMaintenances().add(new Maintenance(null, null, 5));
        int result = facilityMaintenanceServiceImpl.calcMaintenanceCostForFacility();
        assertThat(result, is(13));
    }

    @Test
    public void calcProblemRateForFacilityTest() {
        facilityMaintenanceServiceImpl.getInspections().add(new Inspection(null, true));
        facilityMaintenanceServiceImpl.getInspections().add(new Inspection(null, true));
        facilityMaintenanceServiceImpl.getInspections().add(new Inspection(null, true));
        facilityMaintenanceServiceImpl.getInspections().add(new Inspection(null, false));
        String result = facilityMaintenanceServiceImpl.calcProblemRateForFacility();
        assertThat(result, is("75.00"));
    }

    @Test
    public void listMaintRequestsTest() {
        List<MaintenanceRequest> maintenanceRequests = facilityMaintenanceServiceImpl.listMaintRequests();
        assertEquals(maintenanceRequests, facilityMaintenanceServiceImpl.getMaintenanceRequests());
    }

    @Test
    public void listMaintenanceTest() {
        List<Maintenance> maintenances = facilityMaintenanceServiceImpl.listMaintenance();
        assertEquals(maintenances, facilityMaintenanceServiceImpl.getMaintenances());
    }

    @Test
    public void listFacilityProblemsTest() {
        List<FacilityProblem> facilityProblems = facilityMaintenanceServiceImpl.listFacilityProblems();
        assertEquals(facilityProblems, facilityMaintenanceServiceImpl.getFacilityProblems());
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
        facilityMaintenanceServiceImpl.getMaintenances().add(maintenance);
        long result = facilityMaintenanceServiceImpl.calcDownTimeForFacility();
        assertThat(result, is(5L));
    }
}
