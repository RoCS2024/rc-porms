package com.prefect.office.record.management.appl.facade.prefect.offense.impl;

import com.prefect.office.record.management.appl.facade.prefect.offense.OffenseFacade;
import com.prefect.office.record.management.appl.model.offense.Offense;
import com.prefect.office.record.management.data.dao.prefect.offense.OffenseDao;

import java.util.List;

/**
 * This is an implementation class of the OffenseFacade
 */
public class OffenseFacadeImpl implements OffenseFacade {
    private OffenseDao offenseDAO;

    /**
     * This is a constructor for new OffenseFacadeImpl object
     * This initializes the OffenseDao
     */
    public OffenseFacadeImpl(OffenseDao offenseDao) { this.offenseDAO = offenseDao;}

    @Override
    public boolean addOffense(Offense offense) throws RuntimeException{
        try {
            return offenseDAO.addOffense(offense);
        } catch (Exception e) {
            throw new RuntimeException("Failed to add Offense: " + e.getMessage(), e);
        }
    }

    @Override
    public boolean updateOffense(Offense offense) throws RuntimeException{
        boolean result = false;
        try {
            Offense targetOffense = getOffenseByID(offense.getId());
            if (targetOffense == null) {
                throw new Exception("Offense to update not found. ");
            }
            result = offenseDAO.updateOffense(offense);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        return result;
    }

    @Override
    public Offense getOffenseByID(int id) {
        return offenseDAO.getOffenseByID(id);
    }

    @Override
    public Offense getOffenseByName(String description) {
        return offenseDAO.getOffenseByName(description);
    }

    @Override
    public List<Offense> getAllOffense() {
        return offenseDAO.getAllOffense();
    }

    @Override
    public List<Offense> getAllOffenseByType(String type) {
        try {
            return offenseDAO.getAllOffenseByType(type);
        } catch (Exception e) {
            throw new RuntimeException("Failed to retrieve all Offense by tpe: " + e.getMessage(), e);
        }
    }
}