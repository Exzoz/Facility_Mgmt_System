package com.facility.interfaces;

import java.util.List;


public interface Facility {
    List<Facility> listFacilities();

    Facility getFacilityInformation();

    int requestAvailableCapacity();

    Facility addNewFacility(Facility facility);

    Facility addFacilityDetail(String name, String description);

    Facility removeFacility(Facility facility);
}
