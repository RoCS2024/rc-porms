package com.add.offense.data.dao.offense;

import com.add.offense.app.model.offense.Offense;

public interface OffenseDao {
    boolean saveOffense(Offense offense);
    Offense getOffenseById(long id);

    Object getOffenseById();
}

