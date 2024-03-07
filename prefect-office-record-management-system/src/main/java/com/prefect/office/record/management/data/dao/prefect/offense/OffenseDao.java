package com.prefect.office.record.management.data.dao.prefect.offense;

import com.prefect.office.record.management.app.model.offense.Offense;

public interface OffenseDao {
    Offense getOffenseByID (int id);
    boolean updateOffense (Offense offense);

}
