package com.violation.data.model;

public class Violation {

    private String violation;
    private String type;
    private int commServHours;

    public Violation(String violation, String type, int commServHours) {
        this.violation = violation;
        this.type = type;
        this.commServHours = commServHours;
    }
}