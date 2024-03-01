package com.add.offense.app.facade.offense;

import com.add.offense.app.model.offense.Offense;

public interface OffenseFacade {


     boolean saveOffense(Offense offense);


     Offense getOffenseById();

     Offense getOffenseById(long id);
}

