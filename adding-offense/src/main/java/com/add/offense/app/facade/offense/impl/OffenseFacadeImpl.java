package com.add.offense.app.facade.offense.impl;

import com.add.offense.app.facade.offense.OffenseFacade;
import com.add.offense.app.model.offense.Offense;
import com.add.offense.data.dao.offense.OffenseDao;
import com.add.offense.data.dao.offense.impl.OffenseDaoImpl;

public class OffenseFacadeImpl implements OffenseFacade {
    private OffenseDao offenseDao = new OffenseDaoImpl();

    @Override
    public boolean saveOffense(Offense offense) {
      return offenseDao.saveOffense(offense);
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

