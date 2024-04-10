package com.prefect.office.record.management.appl.model.offense;

import java.sql.Timestamp;

public class Offense {
    private int id;
    private int violationId;
    private String studentId;
    private Timestamp offenseDate;
    private int commServHours;


    public Offense(int id, int violationId, String studentId, Timestamp offenseDate,int commServHours) {
        this.id = id;
        this.violationId = violationId;
        this.studentId = studentId;
        this.offenseDate = offenseDate;
        this.commServHours = commServHours;
    }
    public Offense() {

    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getViolationId() {
        return violationId;
    }

    public void setViolationId(int violationId) {
        this.violationId = violationId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public Timestamp getOffenseDate() {
        return offenseDate;
    }

    public void setOffenseDate(Timestamp offenseDate) {
        this.offenseDate = offenseDate;
    }

    public int getCommServHours() {
        return commServHours;
    }

    public void setCommServHours(int commServHours) {
        this.commServHours = commServHours;
    }
}
