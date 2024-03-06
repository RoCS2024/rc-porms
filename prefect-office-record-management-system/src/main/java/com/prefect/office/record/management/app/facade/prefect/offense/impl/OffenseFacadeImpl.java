package com.prefect.office.record.management.app.facade.prefect.offense.impl;

import com.prefect.office.record.management.app.facade.prefect.offense.OffenseFacade;
import com.prefect.office.record.management.app.model.offense.Offense;
import com.prefect.office.record.management.data.dao.prefect.offense.OffenseDao;
import com.prefect.office.record.management.data.dao.prefect.offense.impl.OffenseDaoImpl;

public class OffenseFacadeImpl implements OffenseFacade {
    private OffenseDao offenseDao;

    public OffenseFacadeImpl(OffenseDao offenseDao) {
        this.offenseDao = offenseDao;
    }

    @Override
    public boolean saveOffense(Offense offense) {
        return offenseDao.addOffense(offense);
    }

    @Override
    public Offense getOffenseById() {
        return null;
    }

    @Override
    public Offense getOffenseById(long id) {
        return offenseDao.getOffenseById(id);
    }
}