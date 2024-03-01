package com.offense.view.app.facade.offense;

import com.offense.view.app.model.offense.Offense;

import java.util.List;

public interface OffenseFacade {
    List<Offense> getAllOffenses();

    Offense getOffenseById(String offenseId);

    <Student> Student getStudentById(String id);
}
