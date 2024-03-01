package com.offense.view.app.facade.offense.impl;

import com.offense.view.app.facade.offense.impl;
import com.offense.view.app.model.offense;
import com.offense.view.app.model.offense.Offense;
import com.offense.view.data.offense.dao;
import com.offense.view.data.offense.dao.OffenseDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static javax.management.Query.times;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OffenseFacadeImplTest {

    private OffenseDao offenseDao;

    private OffenseFacadeImpl offenseFacade;

    @BeforeEach
    public void setUp() {
        offenseDao = mock(Offense.class);
        offenseFacade = new OffenseFacadeImpl();
    }


    @Test
    public void testGetAllEmployee() {
        List<Offense>  OffenseList = new ArrayList<>();
        OffenseList.add(new Offense());
        OffenseList.add(new Offense());
        when(offenseDao.getAllOffenses()).thenReturn(OffenseList);

        List<Offense> retrievedEmployeeList = offenseFacade.getAllOffenses();

        verify(offenseDao, times(1)).getAllOffense();
        assertEquals(OffenseList, retrievedOffenseList);
    }

    @Test
    void testGetEmployeeByNo() {
        String offenseNo = "1";
        Offense offense = new Offense();
        when(offenseDao.getOffenseById(offenseNo)).thenReturn(offense);

        Offense retrievedOffense = offenseFacade.getOffenseById(offenseNo);

        verify(offenseDao, times(1)).getEmployeeByNo(offenseNo);
        assertEquals(offense, retrievedOffense);
    }

}
