package com.facility;
import java.util.List;


public interface Facility {
    List<Facility> listFacilities();
    Facility getFacilityInformation();
    void requestAvailableCapacity();
    Facility addNewFacility(Facility facility);
    Facility addFacilityDetail(FacilityDetail facilityDetail);
    Facility removeFacility(Facility facility);
}
