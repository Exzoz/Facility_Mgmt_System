package com.facility;

import java.util.Date;

public class FacilityProblem {
    private Date created;
    private String description;
    private boolean solved;

    public FacilityProblem(){}

    public FacilityProblem(Date created, String description, boolean solved) {
        this.created = created;
        this.description = description;
        this.solved = solved;
    }