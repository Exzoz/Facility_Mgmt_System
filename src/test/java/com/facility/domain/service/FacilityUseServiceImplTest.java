package com.facility.domain.service;

import com.facility.domain.model.Facility;
import com.facility.domain.model.Status;
import com.facility.domain.model.Usage;
import com.facility.domain.service.impl.FacilityUseServiceImpl;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class FacilityUseServiceImplTest {

    private FacilityUseServiceImpl facilityUseServiceImpl;

    @Before
    public void before() {
        facilityUseServiceImpl = new FacilityUseServiceImpl(new Facility(3));
    }

    @Test
    public void assignFacilityToUseTest() {
        facilityUseServiceImpl.assignFacilityToUse();
        assertThat(facilityUseServiceImpl.getStatus(), is(Status.IN_USE));
    }

    @Test
    public void vacateFacilityTest() {
        facilityUseServiceImpl.vacateFacility();
        assertThat(facilityUseServiceImpl.getStatus(), is(Status.FREE));
    }

    @Test
    public void listActualUsageTest() {
        List<Usage> usages = facilityUseServiceImpl.listActualUsage();
        assertEquals(usages, facilityUseServiceImpl.getUsages());
    }

    @Test
    public void calcUsageRateNoUsageTest() {
        String result = facilityUseServiceImpl.calcUsageRate();
        assertThat(result, is("0"));
    }
}
