package com.prefect.office.record.management.app.facade.prefect.offense.impl;

import com.prefect.office.record.management.app.model.offense.Offense;
import com.prefect.office.record.management.data.dao.prefect.offense.OffenseDao;
import org.junit.jupiter.api.Test;

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
    void testGetAllOffenses() {
        List<Offense> offenses = offenseFacade.getAllOffenses();
        assertNotNull(offenses);
    }

    @Test
    void testGetOffenseById() {
        String offenseId = "sampleOffenseId";
        Offense offense = offenseFacade.getOffenseById(offenseId);
        assertNotNull(offense);
    }

    @Test
    void testGetStudentById() {
        String studentId = "sampleStudentId";
        Object student = offenseFacade.getStudentById(studentId);
        assertNotNull(student);
    }
}
}
