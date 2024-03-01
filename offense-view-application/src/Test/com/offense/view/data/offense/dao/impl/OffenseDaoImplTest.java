package com.offense.view.data.offense.dao.impl;

import com.offense.view.app.model.offense;
import com.offense.view.app.model.offense.Offense;
import com.offense.view.data.offense.dao;
import com.offense.view.data.offense.dao.OffenseDao;
import com.offense.view.data.offense.dao.impl;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class OffenseDaoImplTest {

    @Mock
    private OffenseDao offenseDao;

    @InjectMocks
    private OffenseDaoImpl offenseDaoImpl;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAllOffense() {

        Offense offense1 = new Offense(" 01"," 1", "CT20-0205"," 29-02-2024.19:00",
                new Timestamp(System.currentTimeMillis()), "");

        List<Offense> offenseList = new ArrayList<>();
        offenseList.add(offense1);

        OffenseDao offenseDao = mock(OffenseDao.class);
        when(offenseDao.getAllOffenses()).thenReturn(offenseList);

        List<Offense> expectedResult = offenseDao.getAllOffenses();

        assertEquals(expectedResult.size(), 1);
    }

    @Test
    public void testGetOffenseById() {

        Offense offense1 = new Offense(" 01"," 1", "CT20-0205"," 29-02-2024.19:00",
                new Timestamp(System.currentTimeMillis()), "");

        OffenseDao offenseDao = mock(OffenseDao.class);
        when(offenseDao.getOffenseById("1")).thenReturn(offense1);

        Offense expectedOffense = offenseDao.getOffenseById("1");

        assertEquals(expectedOffense, offense1);
    }
}
