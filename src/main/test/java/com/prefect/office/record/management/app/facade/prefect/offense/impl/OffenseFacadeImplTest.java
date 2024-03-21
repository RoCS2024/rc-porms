package com.prefect.office.record.management.app.facade.prefect.offense.impl;

import com.prefect.office.record.management.app.model.offense.Offense;
import com.prefect.office.record.management.data.dao.prefect.offense.OffenseDao;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class OffenseFacadeImplTest {

    @Test
    void getOffenseByID_ValidID_ReturnsOffense() {
        OffenseDao mockOffenseDao = mock(OffenseDao.class);
        Offense expectedOffense = new Offense(1, 1, "student123", null);
        when(mockOffenseDao.getOffenseByID(1)).thenReturn(expectedOffense);

        OffenseFacadeImpl offenseFacade = new OffenseFacadeImpl(mockOffenseDao);
        Offense actualOffense = offenseFacade.getOffenseByID(1);

        assertEquals(expectedOffense, actualOffense);
    }

    @Test
    void getOffenseByID_InvalidID_ReturnsNull() {
        OffenseDao mockOffenseDao = mock(OffenseDao.class);
        when(mockOffenseDao.getOffenseByID(-1)).thenReturn(null);

        OffenseFacadeImpl offenseFacade = new OffenseFacadeImpl(mockOffenseDao);
        Offense actualOffense = offenseFacade.getOffenseByID(-1);

        assertNull(actualOffense);
    }

    @Test
    void updateOffense_ValidOffense_ReturnsTrue() {
        OffenseDao mockOffenseDao = mock(OffenseDao.class);
        OffenseFacadeImpl offenseFacade = new OffenseFacadeImpl(mockOffenseDao);
        Offense offenseToUpdate = new Offense(1, 1, "student123", null);

        when(mockOffenseDao.getOffenseByID(1)).thenReturn(offenseToUpdate);
        when(mockOffenseDao.updateOffense(offenseToUpdate)).thenReturn(true);

        assertTrue(offenseFacade.updateOffense(offenseToUpdate));
    }

    @Test
    void updateOffense_OffenseNotFound_ThrowsRuntimeException() {
        OffenseDao mockOffenseDao = mock(OffenseDao.class);
        OffenseFacadeImpl offenseFacade = new OffenseFacadeImpl(mockOffenseDao);
        Offense offenseToUpdate = new Offense(1, 1, "student123", null);

        when(mockOffenseDao.getOffenseByID(1)).thenReturn(null);

        assertThrows(RuntimeException.class, () -> offenseFacade.updateOffense(offenseToUpdate));
    }
    @Test
    public void testGetAllOffenses(OffenseFacadeImpl offenseDao) {

        List<Offense> expectedOffenses = new ArrayList<>();
        expectedOffenses.add(new Offense(1, 1, "student123", null));
        expectedOffenses.add(new Offense(2, 2, "student456", null));
        when(offenseDao.getAllOffenses()).thenReturn(expectedOffenses);

        List<Offense> actualOffenses = offenseDao.getAllOffenses();

        assertEquals(expectedOffenses, actualOffenses);
    }

    @Test
    void addOffense_ValidOffense_ReturnsTrue() {
        OffenseDao mockOffenseDao = mock(OffenseDao.class);
        OffenseFacadeImpl offenseFacade = new OffenseFacadeImpl(mockOffenseDao);
        Offense offenseToAdd = new Offense(1, 1, "student123", null);

        when(mockOffenseDao.getOffenseByID(1)).thenReturn(offenseToAdd);
        when(mockOffenseDao.addOffense(offenseToAdd)).thenReturn(true);

        assertTrue(offenseFacade.addOffense(offenseToAdd));
    }

    @Test
    void addOffense_FailureToInsert_ThrowsRuntimeException() {
        OffenseDao mockOffenseDao = mock(OffenseDao.class);
        OffenseFacadeImpl offenseFacade = new OffenseFacadeImpl(mockOffenseDao);
        Offense offenseToAdd = new Offense(1, 1, "student123", null);

        when(mockOffenseDao.addOffense(offenseToAdd)).thenReturn(null);

        assertThrows(RuntimeException.class, () -> offenseFacade.addOffense(offenseToAdd));
    }
}