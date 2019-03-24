package com.facility.view.runner;

import com.facility.model.FacilityDetail;
import com.facility.model.FacilityInformation;
import com.facility.model.FacilityProblem;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringContextRunner {
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
        FacilityDetail facilityDetail = (FacilityDetail) context.getBean("facilityDetail");
        System.out.println("Facility detail: " + facilityDetail);
        FacilityInformation facilityInformation = (FacilityInformation) context.getBean("facilityInformation");
        System.out.println("Facility information: " + facilityInformation);
        FacilityProblem facilityProblem = (FacilityProblem) context.getBean("facilityProblem");
        System.out.println("Facility problem: " + facilityProblem);
    }
}
