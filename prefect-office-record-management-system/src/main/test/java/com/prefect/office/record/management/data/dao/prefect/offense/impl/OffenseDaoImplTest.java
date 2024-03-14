package com.prefect.office.record.management.data.dao.prefect.offense.impl;
import com.prefect.office.record.management.app.model.offense.Offense;
import org.junit.jupiter.api.Test;
import java.sql.SQLException;
import java.sql.Timestamp;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

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
    void addOffense_ValidOffense_ReturnsTrue() throws SQLException {
        OffenseDaoImpl offenseDao = new OffenseDaoImpl();
        Offense offenseToAdd = new Offense(1, 1, "student123", new Timestamp(System.currentTimeMillis()));

        OffenseDaoImpl mockDao = mock(OffenseDaoImpl.class);
        when(mockDao.saveOffense(offenseToAdd)).thenReturn(true);

        assertTrue(mockDao.saveOffense(offenseToAdd));
    }

    @Test
    void addOffense_InvalidOffense_ReturnsFalse() throws SQLException {
        OffenseDaoImpl offenseDao = new OffenseDaoImpl();
        Offense invalidOffense = new Offense(-1, 1, "student123", new Timestamp(System.currentTimeMillis()));
        OffenseDaoImpl mockDao = mock(OffenseDaoImpl.class);
        when(mockDao.saveOffense(invalidOffense)).thenReturn(false);

        assertFalse(mockDao.saveOffense(invalidOffense));
    }
}
