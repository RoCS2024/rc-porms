package com.prefect.office.record.management.app.model.offense;

import java.sql.Timestamp;

public class Offense {
    private int id;
    private String studentId;
    private Timestamp offenseDate;

    public Offense() {
    }

    public Offense(int id, String studentId, Timestamp offenseDate) {
        this.id = id;
        this.studentId = studentId;
        this.offenseDate = offenseDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

}