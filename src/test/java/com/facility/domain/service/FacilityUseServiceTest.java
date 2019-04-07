package com.facility.domain.service;

import com.facility.domain.model.Facility;
import com.facility.domain.model.Maintenance;
import com.facility.domain.model.Status;
import com.facility.domain.model.Usage;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class FacilityUseServiceTest {

    private FacilityUseService facilityUseService;

    @Before
    public void before() {
        facilityUseService = new FacilityUseService(new Facility(3));
    }

    @Test
    public void assignFacilityToUseTest() {
        facilityUseService.assignFacilityToUse();
        assertThat(facilityUseService.getStatus(), is(Status.IN_USE));
    }

    @Test
    public void vacateFacilityTest() {
        facilityUseService.vacateFacility();
        assertThat(facilityUseService.getStatus(), is(Status.FREE));
    }

    @Test
    public void listActualUsageTest() {
        List<Usage> usages = facilityUseService.listActualUsage();
        assertEquals(usages, facilityUseService.getUsages());
    }

    @Test
    public void calcUsageRateNoUsageTest() {
        String result = facilityUseService.calcUsageRate();
        assertThat(result, is("0"));
    }

    @Test
    public void calcUsageRateWithUsageTest() {
        facilityUseService.getUsages().add(new Usage());
        facilityUseService.getUsages().add(new Usage());
        facilityUseService.getFacility().getFacilityMaintenanceService().getMaintenances().add(new Maintenance());
        String result = facilityUseService.calcUsageRate();
        assertThat(result, is("66.67"));
    }
}
