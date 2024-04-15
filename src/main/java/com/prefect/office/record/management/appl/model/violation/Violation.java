package com.prefect.office.record.management.appl.model.violation;

/**
 * Represents a record of a violation.
 */
public class Violation {
    private int id;
    private String violation;
    private String type;
    private int commServHours;

    /**
     * Constructs a new Violation object with default values.
     */
    public Violation() {
    }

    /**
     * Constructs a new Violation object.
     *
     * @param violation     The description of the violation.
     * @param type          The type of violation.
     * @param commServHours The number of community service hours associated with the violation.
     */

    public Violation(String violation, String type, int commServHours) {
        this.violation = violation;
        this.type = type;
        this.commServHours = commServHours;
    }

    /**
     * Sets the unique identifier of the violation record.
     * @param id The unique identifier to set.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Retrieves the violation for student who violated.
     * @return violation.
     */
    public String getViolation() {
        return violation;
    }

    /**
     * Retrieves the type for violation.
     * @return type.
     */
    public String getType() {
        return type;
    }

    /**
     * Retrieves the number of hours of community service.
     * @return commServHours.
     */
    public int getCommServHours() {
        return commServHours;
    }

    /**
     * Retrieves the unique identifier of the violation record.
     * @return The unique identifier of the violation record.
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the violation of the student who violated.
     * @param violation The violation to set.
     */
    public void setViolation(String violation) {
        this.violation = violation;
    }

    /**
     * Sets the type of violation.
     * @param type The type of violation to set.
     */
    public void setType(String type) {
        this.type = type;
    }
    /**
     * Sets the number of hour of community service.
     * @param commServHours The hours of community service to set.
     */
    public void setCommServHours(int commServHours) {
        this.commServHours = commServHours;
    }
}
