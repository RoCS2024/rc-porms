package com.prefect.office.record.management.data.dao.prefect.offense;

import com.prefect.office.record.management.appl.model.offense.Offense;

import java.util.List;
/**
 * This is the interface for the OffenseDao
 */
public interface OffenseDao {
    /**
     * This retrieves all Offenses from the database
     * @return list of all the offenses
     */
    List<Offense> getAllOffenses();

    /**
     * This gets an Offense from the database with a specific ID
     * @param id is the id of the Offense
     * @return the Offense with specific ID
     */
    Offense getOffenseByID (int id);

    /**
     * This updates an Offense in the database
     * @param offense is the Offense to update
     * @return true if update of Offense is successful
     */
    boolean updateOffense (Offense offense);

    /**
     * This adds an Offense in the database
     * @param offense is the Offense to add
     * @return true if adding of Offense is successful
     */
    boolean addOffense(Offense offense);
}
