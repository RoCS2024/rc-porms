package com.prefect.office.record.management.app.facade.prefect.offense;

import com.prefect.office.record.management.app.model.offense.Offense;

public interface OffenseFacade {
    boolean saveOffense(Offense offense);
    Offense getOffenseById(long id);
}