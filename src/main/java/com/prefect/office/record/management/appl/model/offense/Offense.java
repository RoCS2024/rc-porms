package com.prefect.office.record.management.appl.model.offense;

/**
 * Represents a record of an offense.
 */
public class Offense {
    private int id;
    private String type;
    private String description;

    /**
     * Constructs a new Offense object with default values.
     */
    public Offense() {
    }

    /**
     * Constructs a new Offense object.
     *
     * @param type          The type of offense.
     * @param description     The description of the offense.
     */

    public Offense(int id, String type, String description) {
        this.id = id;
        this.type = type;
        this.description = description;
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
     * Retrieves the type for offense.
     * @return type.
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the type of offense.
     * @param type The type of offense to set.
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Retrieves the offense violated.
     * @return offense.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of the Offense violated.
     * @param description The offense to set.
     */
    public void setDescription(String description) {
        this.description = description;
    }
}
