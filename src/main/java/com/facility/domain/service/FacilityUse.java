package com.facility.domain.service;

import com.facility.domain.model.Facility;
import com.facility.domain.model.Status;
import com.facility.domain.model.Usage;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public interface FacilityUse {

    public boolean isInUseDuringInterval(Date start, Date end);
    public void assignFacilityToUse();
    public void vacateFacility();
    public List<Usage> listActualUsage();
    public String calcUsageRate();
    public List<Usage> getUsages();
}
