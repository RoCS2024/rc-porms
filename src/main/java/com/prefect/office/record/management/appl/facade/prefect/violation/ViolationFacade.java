package com.prefect.office.record.management.appl.facade.prefect.violation;


import com.prefect.office.record.management.appl.model.offense.Offense;
import com.prefect.office.record.management.appl.model.violation.Violation;

import java.util.List;
/**
 * This is the interface to the ViolationFacade
 */
public interface ViolationFacade {

    /**
     * This adds a violation in the database.
     * @param violation is the violation to add in the database
     * @param type is the type of violation to be recorded in the database
     * @param commServHours is the number of community service to be recorded in the database
     */
    void addViolation(String violation, String type, int commServHours);

    /**
     * This updates Violation to the database
     * @param violation is the violation to update
     */
    boolean updateViolation(Violation violation);

    /**
     * This gets a Violation from the database with a specific ID
     * @param id is the id of the Violation
     * @return the Violation with specific ID
     */
    Violation getViolationByID (int id);

    /**
     * This retrieves all violation in the database
     * @return list of violation from the database
     */
    List<Violation> getAllViolation();

}