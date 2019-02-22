package com.facility;

import java.util.Date;


public class Maintenance {
    private Date start;
    private Date end;
    private int cost;

    public Maintenance(){}

    public Maintenance(Date start) {
        this.start = new Date();
    }

    public Maintenance(Date start, Date end, int cost) {
        this.start = start;
        this.end = end;
        this.cost = cost;
    }

    public Date getStart() {
        return start;
    }
    public void setStart(Date start) {
        this.start = start;
    }
    public Date getEnd() {
        return end;
    }
    public void setEnd(Date end) {
        this.end = end;
    }
    public int getCost() {
        return cost;
    }
    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Maintenance [start=" + start + ", end=" + end + ", cost="
                + cost + "]";
    }

}
