package com.prefect.office.record.management.appl.facade.prefect.offense.impl;

import com.prefect.office.record.management.appl.facade.prefect.offense.OffenseFacade;
import com.prefect.office.record.management.appl.model.offense.Offense;
import com.prefect.office.record.management.appl.model.violation.Violation;
import com.prefect.office.record.management.data.dao.prefect.offense.OffenseDao;
import com.prefect.office.record.management.data.dao.prefect.offense.impl.OffenseDaoImpl;
import com.student.information.management.appl.model.student.Student;

import java.util.List;

/**
 * An implementation class of the Offence Facade.
 */

public class OffenseFacadeImpl implements OffenseFacade {

    private OffenseDao offenseDao;

    public OffenseFacadeImpl(OffenseDao offenseDao) {
        this.offenseDao = offenseDao;
    }

    public OffenseFacadeImpl() {

    }

    public List<Offense> getAllOffenses() {
        try {
            return offenseDao.getAllOffenses();
        } catch (Exception e) {
            throw new RuntimeException("Failed to retrieve all offenses: " + e.getMessage(), e);
        }
    }

    @Override
    public Offense getOffenseByID(int id) {
        return offenseDao.getOffenseByID(id);
    }

    @Override
    public List<Offense> getAllOffenseByStudent(Student studentId) {
        try {
            return offenseDao.getAllOffenseByStudent(studentId);
        } catch (Exception e) {
            throw new RuntimeException("Failed to retrieve all offenses: " + e.getMessage(), e);
        }
    }


    @Override
    public boolean updateOffense(Offense offense) throws RuntimeException{
        boolean result = false;
        try {
            Offense targetOffense = getOffenseByID(offense.getId());
            if (targetOffense == null) {
                throw new Exception("Offense to update not found.");
            }
            result = offenseDao.updateOffense(offense);
        } catch (Exception e) {
            String errorMessage = e.getMessage();
            if (errorMessage != null) {
                throw new RuntimeException(errorMessage);
            } else {
                throw new RuntimeException("An error occurred while updating the offense information.");
            }
        }
        return result;
    }


    @Override
    public boolean addOffense(Offense offense) throws RuntimeException {
        try {
           return offenseDao.addOffense(offense);
        } catch (Exception e) {
            throw new RuntimeException("Failed to add offense: " + e.getMessage(), e);
        }
    }
}