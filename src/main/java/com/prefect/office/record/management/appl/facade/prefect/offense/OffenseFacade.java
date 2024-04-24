package com.prefect.office.record.management.appl.facade.prefect.offense;

import com.prefect.office.record.management.appl.model.offense.Offense;

import java.util.List;

/**
 * An interface to the Offense Facade.
 */

public interface OffenseFacade {

    /**
     * Retrieves all Offense from the database.
     *
     * @return list of all Offense.
     * */
    List<Offense> getAllOffenses();

    /**
     * Retrieves a Student from the database with specified id.
     *
     * @param id the id of the students.
     * @return the Offense.
     * */
    Offense getOffenseByID (int id);

    /**
     * Updates a Student in the database.
     *
     * @param offense  offense to update.
     * @return true if update is successful.
     * */
    boolean updateOffense (Offense offense);

    /**
     * Adds a Student to the database.
     *
     * @param offense offense to add.
     * @return true if adding is successful.
     * */

    boolean addOffense(Offense offense);
}