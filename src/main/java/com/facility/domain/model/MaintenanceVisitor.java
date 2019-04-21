package com.facility.domain.model;


public class MaintenanceVisitor {

    private double maintenanceDowntime;

    //calculate downtime
    public void visit(Maintenance maintenance) {
        maintenanceDowntime = (maintenance.getEnd().getTime() - maintenance.getStart().getTime()) / 1000;
    }

    public double getMaintenanceDowntime() {
        return maintenanceDowntime;
    }

    public void setMaintenanceDowntime(double maintenanceDowntime) {
        this.maintenanceDowntime = maintenanceDowntime;
    }
}