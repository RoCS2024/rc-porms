package com.prefect.office.record.management.data.dao.prefect.offense.impl;

import com.prefect.office.record.management.app.model.offense.Offense;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OffenseDaoImplTest {

    @Test
    void getOffenseByID_ValidID_ReturnsOffense() {
        OffenseDaoImpl offenseDao = new OffenseDaoImpl();
        int validId = 1;
        Offense offense = offenseDao.getOffenseByID(validId);
        assertNotNull(offense);
        assertEquals(validId, offense.getId());
    }

    @Test
    void getOffenseByID_InvalidID_ReturnsNull() {
        OffenseDaoImpl offenseDao = new OffenseDaoImpl();
        int invalidId = -1;
        Offense offense = offenseDao.getOffenseByID(invalidId);
        assertNull(offense);
    }

    @Test
    void updateOffense_ValidOffense_ReturnsTrue() {
        OffenseDaoImpl offenseDao = new OffenseDaoImpl();
        Offense offenseToUpdate = new Offense(1, 1, "student123", new Timestamp(System.currentTimeMillis()));
        assertTrue(offenseDao.updateOffense(offenseToUpdate));
    }

    @Test
    void updateOffense_InvalidOffense_ReturnsFalse() {
        OffenseDaoImpl offenseDao = new OffenseDaoImpl();
        Offense invalidOffense = new Offense(-1, 1, "student123", new Timestamp(System.currentTimeMillis()));
        assertFalse(offenseDao.updateOffense(invalidOffense));
    }
    @Test
    void testGetAllOffenses() {
        OffenseDaoImpl offenseDao = new OffenseDaoImpl();
        List<Offense> offenses = offenseDao.getAllOffenses();
        assertNotNull(offenses);
        assertFalse(offenses.isEmpty());
    }
    @Test
    void addOffense_ValidOffense_ReturnsTrue() {
         OffenseDaoImpl offenseDao = new OffenseDaoImpl();
        Offense validOffenseToAdd = new Offense(1, 1, "student123", new Timestamp(System.currentTimeMillis()));
        assertTrue(offenseDao.addOffense(validOffenseToAdd));
}

    @Test
    void addOffense_InvalidOffense_ReturnsFalse() {
        OffenseDaoImpl offenseDao = new OffenseDaoImpl();
        Offense invalidOffenseToAdd = new Offense(-1, 1, "student123", new Timestamp(System.currentTimeMillis()));
        assertFalse(offenseDao.addOffense(invalidOffenseToAdd));
    }
}
