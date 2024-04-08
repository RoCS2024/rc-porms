/**
 * this is the Offense class where the fields, constructors, getter and setter resides.
 */
package com.prefect.office.record.management.appl.model.offense;

import java.sql.Timestamp;
/**
 * This is offense model.
 */
public class Offense {

    /**
     * This is the offense fields.
     */
    private int id;
    private int violationId;
    private String studentId;
    private Timestamp offenseDate;


    public Offense(int id, int violationId, String studentId, Timestamp offenseDate) {
        this.id = id;
        this.violationId = violationId;
        this.studentId = studentId;
        this.offenseDate = offenseDate;
    }
    public Offense() {

    }

    /**
     * This is the offense Getter and Setter.
     */
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
}
