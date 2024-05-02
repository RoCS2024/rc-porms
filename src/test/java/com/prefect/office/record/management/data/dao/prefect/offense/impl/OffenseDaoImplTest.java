package com.prefect.office.record.management.data.dao.prefect.offense.impl;

import com.prefect.office.record.management.appl.model.offense.Offense;
import com.prefect.office.record.management.data.dao.prefect.offense.OffenseDao;
import com.student.information.management.appl.model.student.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
    public void testGetAllOffenses() {
        when(offenseDao.getAllOffenses()).thenReturn(offenses);
        List<Offense> offenseList = offenseDao.getAllOffenses();
        assertEquals(offenseList.size(), 2);
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
    public void testAddOffense() {
        Offense offense = new Offense();
        offense.setId(1);

        when(offenseDao.addOffense(offense)).thenReturn(true);
        when(offenseDao.getOffenseByID(1)).thenReturn(offense);

        Offense expectedOffense = offenseDao.getOffenseByID(1);
        assertEquals(expectedOffense.getId(), offense.getId());
    }
    @Test
    public void testUpdateOffense() {
        Offense offense = new Offense();
        offense.setId(1);

        when(offenseDao.addOffense(offense)).thenReturn(true);
        when(offenseDao.updateOffense(offense)).thenReturn(true);
        when(offenseDao.getOffenseByID(1)).thenReturn(offense);

        Offense expectedOffense = offenseDao.getOffenseByID(1);
        assertEquals(expectedOffense.getId(), offense.getId());
    }

    @Test
    public void testGetAllOffenseByStudent() {
        Student student = new Student();

        Offense offense1 = new Offense();
        offense1.setStudent(student);

        when(offenseDao.getAllOffenseByStudent(student)).thenReturn(offenses);
        List<Offense> offenseList = offenseDao.getAllOffenseByStudent(student);
        assertEquals(offenseList.size(), 2);
    }
}