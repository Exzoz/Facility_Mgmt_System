package com.facility.view.runner;

import com.facility.domain.model.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringContextRunner {
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");

        Facility facility = (Facility) context.getBean("facility");
        System.out.println("Facility: " + facility);
        FacilityDetail facilityDetail = (FacilityDetail) context.getBean("facilityDetail");
        System.out.println("Facility Detail: " + facilityDetail);
        FacilityInformation facilityInformation = (FacilityInformation) context.getBean("facilityInformation");
        System.out.println("Facility Information: " + facilityInformation);
        FacilityProblem facilityProblem = (FacilityProblem) context.getBean("facilityProblem");
        System.out.println("Facility Problem: " + facilityProblem);
        Inspection inspection = (Inspection) context.getBean("inspection");
        System.out.println("Inspection: " + inspection);
        Maintenance maintenance = (Maintenance) context.getBean("maintenance");
        System.out.println("Maintenance: " + maintenance);
        MaintenanceRequest maintenanceRequest = (MaintenanceRequest) context.getBean("maintenanceRequest");
        System.out.println("MaintenanceRequest: " + maintenanceRequest);
        Usage usage = (Usage) context.getBean("usage");
        System.out.println("Usage: " + usage);
    }
}
