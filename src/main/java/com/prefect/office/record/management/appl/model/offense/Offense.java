package com.prefect.office.record.management.appl.model.offense;

import java.sql.Timestamp;

/**
 * Represents a record of a student offense.
 */
public class Offense {

    private int id;
    private int violationId;
    private String studentId;
    private Timestamp offenseDate;

    /**
     * Constructs a new Offense object.
     *
     * @param id          The unique identifier of the offense record.
     * @param violationId The ID of the violation associated with the offense.
     * @param studentId   The ID of the student who committed the offense.
     * @param offenseDate The timestamp indicating the date and time of the offense.
     */
    public Offense(int id, int violationId, String studentId, Timestamp offenseDate) {
        this.id = id;
        this.violationId = violationId;
        this.studentId = studentId;
        this.offenseDate = offenseDate;
    }

    /**
     * Constructs a new Offense object with default values.
     */
    public Offense() {

    }

    /**
     * Retrieves the unique identifier of the offense record.
     * @return The unique identifier of the offense record.
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the unique identifier of the offense record.
     * @param id The unique identifier to set.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Retrieves the ID of the violation associated with the offense.
     * @return The ID of the violation.
     */
    public int getViolationId() {
        return violationId;
    }

    /**
     * Sets the ID of the violation associated with the offense.
     * @param violationId The ID of the violation to set.
     */
    public void setViolationId(int violationId) {
        this.violationId = violationId;
    }

    /**
     * Retrieves the ID of the student who committed the offense.
     * @return The ID of the student.
     */
    public String getStudentId() {
        return studentId;
    }

    /**
     * Sets the ID of the student who committed the offense.
     * @param studentId The ID of the student to set.
     */
    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }


    /**
     * Retrieves the timestamp indicating the date and time of the offense.
     * @return The timestamp indicating the date and time of the offense.
     */
    public Timestamp getOffenseDate() {
        return offenseDate;
    }

    /**
     * Sets the timestamp indicating the date and time of the offense.
     * @param offenseDate The timestamp to set.
     */
    public void setOffenseDate(Timestamp offenseDate) {
        this.offenseDate = offenseDate;
    }
}
