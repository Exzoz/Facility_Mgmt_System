package com.facility.interfaces;
import com.facility.model.Inspection;
import com.facility.model.Usage;

import java.util.Date;
import java.util.List;


public interface FacilityUse {
    boolean isInUseDuringInterval(Date start, Date end);

    void assignFacilityToUse();

    void vacateFacility();

    List<Inspection> listInspections();

    List<Usage> listActualUsage();

    String calcUsageRate();
}
