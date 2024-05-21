package com.prefect.office.record.management.data.dao.prefect.offense;

import com.prefect.office.record.management.appl.model.offense.Offense;

import java.util.List;
/**
 * This is the interface for the OffenseDao
 */
public interface OffenseDao {

    /**
     * This gets an Offense from the database with a specific ID
     * @param id is the id of the Offense
     * @return the Offense with specific ID
     */
    Offense getOffenseByID(int id);

    /**
     * This gets an Offense from the database with a specific Name
     * @param description is the Offense description or name
     * @return the Offense with specific description or name
     */
    Offense getOffenseByName(String description);

    /**
     * This adds Offense to the database
     * @param offense is the Offense to add
     */
    boolean addOffense(Offense offense);

    /**
     * This updates Offense to the database
     * @param offense is the Offense to update
     */
    boolean updateOffense(Offense offense);

    /**
     * This retrieves all Offense from the database
     * @return list of Offense
     */
    List<Offense> getAllOffense();

    /**
     * This retrieves all Offense by type from the database
     * @return list of Offense by Type
     */
    List<Offense> getAllOffenseByType(String type);
}

