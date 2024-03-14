package com.prefect.office.record.management.app.facade.prefect.offense.impl;

import com.prefect.office.record.management.app.facade.prefect.offense.OffenseFacade;
import com.prefect.office.record.management.app.model.offense.Offense;
import com.prefect.office.record.management.data.dao.prefect.offense.OffenseDao;

import java.util.List;

public class OffenseFacadeImpl implements OffenseFacade {
    private final OffenseDao offenseDao;

    public OffenseFacadeImpl(OffenseDao offenseDao) {
        this.offenseDao = offenseDao;
    }

    @Override
    public Offense getOffenseById(long id) {
        return offenseDao.getOffenseById(id);
    }

    @Override
    public boolean saveOffense(Offense offense) {
        boolean result = false;
        try {
            Offense targetOffense = getOffenseById(offense.getId());
            if (targetOffense != null) {

                throw new RuntimeException("Offense to add not found.");
            }
            result = offenseDao.saveOffense(offense);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        return result;
    }

}