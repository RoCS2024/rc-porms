package com.prefect.office.record.management.app.facade.prefect.offense.impl;

import com.prefect.office.record.management.app.facade.prefect.offense.OffenseFacade;
import com.prefect.office.record.management.app.model.offense.Offense;
import com.prefect.office.record.management.data.dao.prefect.offense.OffenseDao;
import com.prefect.office.record.management.data.dao.prefect.offense.impl.OffenseDaoImpl;

import java.util.List;

public class OffenseFacadeImpl implements OffenseFacade {

    OffenseDao offenseDao = new OffenseDaoImpl();

    public OffenseFacadeImpl(OffenseDao offenseDao){

    }
    public List<Offense> getAllOffenses() {
        return offenseDao.getAllOffenses();
    }

    @Override
    public Offense getOffenseByID(int id) {
        return offenseDao.getOffenseByID(id);
    }

    @Override
    public boolean updateOffense(Offense offense) {
        boolean result = false;
        try {
            Offense targetOffense = getOffenseByID(offense.getId());
            if(targetOffense == null) {
                throw new Exception("Offense to update not found. ");
            }
            result = offenseDao.updateOffense(offense);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        return result;
    }
    @Override
    public boolean addOffense(Offense offense) {
        return offenseDao.addOffense(offense);
    }
}