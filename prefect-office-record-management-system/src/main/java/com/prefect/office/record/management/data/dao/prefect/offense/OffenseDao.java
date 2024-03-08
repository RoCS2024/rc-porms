package com.prefect.office.record.management.data.dao.prefect.offense;

import com.prefect.office.record.management.app.model.offense.Offense;

public interface OffenseDao {
    boolean saveOffense(Offense offense);
    Offense getOffenseById(long id);

    Offense getOffenseByID(int id);
}
