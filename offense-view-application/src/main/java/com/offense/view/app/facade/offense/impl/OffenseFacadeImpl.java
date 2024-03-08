package com.offense.view.app.facade.offense.impl;

import com.offense.view.app.facade.offense.OffenseFacade;
import com.offense.view.app.model.offense.Offense;
import com.offense.view.data.offense.dao.OffenseDao;
import com.offense.view.data.offense.dao.impl.OffenseDaoImpl;

import java.util.List;
import java.util.ArrayList;

public class OffenseFacadeImpl implements OffenseFacade {

    private OffenseDao offenseDao = new OffenseDaoImpl();
    @Override
    public List<Offense> getAllOffenses() {
        List<Offense> offenses = new ArrayList<>();
        offenses = offenseDao.getAllOffenses();

        return offenses;
    }

    @Override
    public Offense getOffenseById(String offenseId) {
        return offenseDao.getOffenseById(offenseId);
    }

    @Override
    public <Student> Student getStudentById(String id) {
        return null;
    }
}