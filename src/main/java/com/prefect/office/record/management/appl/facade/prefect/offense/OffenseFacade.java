package com.prefect.office.record.management.appl.facade.prefect.offense;


import com.prefect.office.record.management.appl.model.offense.Offense;

import java.util.List;
/**
 * This is the interface to the OffenseFacade
 */
public interface OffenseFacade {

    /**
     * This adds an offense in the database.
     * @param offense is the offense to add in the database
     */
    boolean addOffense(Offense offense);

    /**
     * This updates offense to the database
     * @param offense is the offense to update
     */
    boolean updateOffense(Offense offense);

    /**
     * This gets an Offense from the database with a specific ID
     * @param id is the id of the Offense
     * @return the Offense with specific ID
     */
    Offense getOffenseByID(int id);

    /**
     * This gets an offense from the database with a specific name or description
     * @param description is the offense name or description
     * @return the Offense with specific name or description
     */
    Offense getOffenseByName(String description);

    /**
     * This retrieves all offense in the database
     * @return list of offense from the database
     */
    List<Offense> getAllOffense();

    /**
     * This retrieves all offense by type in the database
     * @return list of offense by type from the database
     */
    List<Offense> getAllOffenseByType(String type);

}