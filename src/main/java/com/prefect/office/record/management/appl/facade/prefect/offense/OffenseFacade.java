package com.prefect.office.record.management.appl.facade.prefect.offense;

import com.prefect.office.record.management.appl.model.offense.Offense;

import java.util.List;

/**
 * This is the interface to the OffenseFacade.
 */
public interface OffenseFacade {

    /**
     * Retrieves all offenses from the database.
     *
     * @return A list of all offenses stored in the database.
     */
    List<Offense> getAllOffenses();

    /**
     * Retrieves an offense by its unique ID from the database.
     *
     * @param id The ID of the offense to retrieve.
     * @return The offense object corresponding to the given ID, if found; otherwise, null.
     */
    Offense getOffenseByID(int id);

    /**
     * Updates an existing offense record in the database.
     *
     * @param offense The offense object containing the updated information.
     * @return true if the offense is successfully updated, false otherwise.
     */
    boolean updateOffense(Offense offense);

    /**
     * Adds a new offense record to the database.
     *
     * @param offense The offense object to add to the database.
     * @return true if the offense is successfully added, false otherwise.
     */
    boolean addOffense(Offense offense);
}