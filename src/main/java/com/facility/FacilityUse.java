package com.facility;
import java.util.Date;
import java.util.List;


public interface FacilityUse {
    boolean isInUseDuringInterval(Date start, Date end);

    void assignFacilityToUse();

    Facility vacateFacility();

    List<Inspection> listInspections();

    List<Usage> listActualUsage();

    double calcUsageRate();
}
