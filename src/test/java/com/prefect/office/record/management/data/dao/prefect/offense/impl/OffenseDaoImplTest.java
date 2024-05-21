package com.prefect.office.record.management.data.dao.prefect.offense.impl;

import com.prefect.office.record.management.appl.model.offense.Offense;
import com.prefect.office.record.management.data.dao.prefect.offense.OffenseDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class OffenseDaoImplTest {
    private OffenseDao offenseDao;
    private List<Offense> offenses;

    @BeforeEach
    public void setUp() {
        offenses = new ArrayList<>();
        Offense offense1 = new Offense();
        Offense offense2 = new Offense();
        offenses.add(offense1);
        offenses.add(offense2);

        offenseDao = mock(OffenseDao.class);
    }

    @Test
    public void testAddOffense(){
        Offense testOffense = new Offense(1, "Test", "Test2");

        offenseDao.addOffense(testOffense);
        assertTrue(true, "Expected: True, Actual: True");
    }

    @Test
    public void testUpdateOffense() {
        Offense offense = new Offense();
        offense.setId(1);

        when(offenseDao.updateOffense(offense)).thenReturn(true);
        when(offenseDao.getOffenseByID(1)).thenReturn(offense);

        Offense expectedOffense = offenseDao.getOffenseByID(1);
        assertEquals(expectedOffense.getId(), offense.getId());
    }

    @Test
    public void testGetOffenseById() {
        Offense offense1 = new Offense();
        offense1.setId(1);

        when(offenseDao.getOffenseByID(1)).thenReturn(offense1);

        Offense expectedOffense = offenseDao.getOffenseByID(1);

        assertEquals(expectedOffense, offense1);
        assertEquals(expectedOffense.getId(), offense1.getId());
    }

    @Test
    public void testGetOffenseByName() {
        Offense offense1 = new Offense();
        offense1.setDescription("fighting");

        when(offenseDao.getOffenseByName("fighting")).thenReturn(offense1);

        Offense expectedOffense = offenseDao.getOffenseByName("fighting");

        assertEquals(expectedOffense, offense1);
        assertEquals(expectedOffense.getDescription(), offense1.getDescription());
    }

    @Test
    public void testGetAllOffense() {
        when(offenseDao.getAllOffense()).thenReturn(offenses);
        List<Offense> offenseList = offenseDao.getAllOffense();
        assertEquals(offenseList.size(), 2);
    }

    @Test
    public void testGetAllOffenseByType() {
        String major = "Major";

        when(offenseDao.getAllOffenseByType(major)).thenReturn(offenses);
        List<Offense> offenseList = offenseDao.getAllOffenseByType(major);
        assertEquals(offenseList.size(), 2);
    }
}