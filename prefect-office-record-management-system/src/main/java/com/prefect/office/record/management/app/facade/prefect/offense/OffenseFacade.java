package com.prefect.office.record.management.app.facade.prefect.offense;

import com.prefect.office.record.management.app.model.offense.Offense;

import java.util.List;

public interface OffenseFacade {
    List<Offense> getAllOffenses();
    Offense getOffenseByID (int id);
    boolean updateOffense (Offense offense);

    boolean addOffense(Offense offense);
}