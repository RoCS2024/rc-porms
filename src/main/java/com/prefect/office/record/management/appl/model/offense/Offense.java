package com.prefect.office.record.management.appl.model.offense;

import com.prefect.office.record.management.appl.model.violation.Violation;
import com.student.information.management.appl.model.student.Student;

import java.sql.Timestamp;

/**
 * Represents a record of a student offense.
 */
public class Offense {

    private int id;
    private Violation violation;
    private Student student;
    private Timestamp offenseDate;
    private int commServHours;

    /**
     * Constructs a new Offense object.
     *
     * @param id          The unique identifier of the offense record.
     * @param violationId The ID of the violation associated with the offense.
     * @param studentId   The ID of the student who committed the offense.
     * @param offenseDate The timestamp indicating the date and time of the offense.
     */  
    public Offense(int id, Violation violation, Student student, Timestamp offenseDate, int commServHours) {
        this.id = id;
        this.violation = violation;
        this.student = student;
        this.offenseDate = offenseDate;
        this.commServHours = commServHours;
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

    public Violation getViolation() {
        return violation;
    }

    public void setViolation(Violation violation) {
        this.violation = violation;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
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

    public int getCommServHours() {
        return commServHours;
    }

    public void setCommServHours(int commServHours) {
        this.commServHours = commServHours;
    }
}
