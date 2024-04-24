package com.prefect.office.record.management.appl.facade.prefect.offense;

import com.prefect.office.record.management.appl.model.offense.Offense;
import com.student.information.management.appl.model.student.Student;

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
     * Retrieves an Offense from the database with specified id.
     *
     * @param id the id of the offense.
     * @return the Offense.
     * */
    Offense getOffenseByID (int id);

    /**
     * Retrieves all offense from the database with specified student id.
     *
     * @param studentId the id of the students.
     * @return the Offense.
     * */
    List<Offense> getAllOffenseByStudentId(Student studentId);

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