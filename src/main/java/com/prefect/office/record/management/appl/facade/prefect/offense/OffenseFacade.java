package com.prefect.office.record.management.appl.facade.prefect.offense;

import com.prefect.office.record.management.appl.model.offense.Offense;

import java.util.List;

public interface OffenseFacade {
    List<Offense> getAllOffenses();
    Offense getOffenseByID (int id);
    boolean updateOffense (Offense offense);

    boolean addOffense(Offense offense);
}