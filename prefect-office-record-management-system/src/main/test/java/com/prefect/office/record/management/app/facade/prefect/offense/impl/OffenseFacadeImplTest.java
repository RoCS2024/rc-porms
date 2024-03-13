package com.prefect.office.record.management.app.facade.prefect.offense.impl;

import com.prefect.office.record.management.app.model.offense.Offense;
import com.prefect.office.record.management.data.dao.prefect.offense.OffenseDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.sql.Timestamp;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class OffenseFacadeImplTest {

    @Mock
    private OffenseDao mockOffenseDao;

    private OffenseFacadeImpl offenseFacade;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        offenseFacade = new OffenseFacadeImpl(mockOffenseDao);
    }
    @Test
    void testGetOffenseById_ValidId_ReturnsOffense() {
        Offense expectedOffense = new Offense(1, 1, "student123", new Timestamp(System.currentTimeMillis()));
        when(mockOffenseDao.getOffenseById(1)).thenReturn(expectedOffense);
        Offense actualOffense = offenseFacade.getOffenseById(1);

        assertEquals(expectedOffense, actualOffense);
    }

    @Test
    void testGetOffenseById_InvalidId_ReturnsNull() {
        when(mockOffenseDao.getOffenseById(-1)).thenReturn(null);
        Offense actualOffense = offenseFacade.getOffenseById(-1);
        assertNull(actualOffense);
    }
    @Test
    void testSaveOffense_Success() {
        Offense offenseToSave = new Offense(1, 1, "student123", new Timestamp(System.currentTimeMillis()));
        when(mockOffenseDao.getOffenseById(1)).thenReturn(null);
        when(mockOffenseDao.saveOffense(offenseToSave)).thenReturn(true);
        boolean result = offenseFacade.saveOffense(offenseToSave);

        assertTrue(result);
        verify(mockOffenseDao, times(1)).getOffenseById(1);
        verify(mockOffenseDao, times(1)).saveOffense(offenseToSave);
    }
    @Test
    void testSaveOffense_Failure() {
        Offense offenseToSave = new Offense(1, 1, "student123", new Timestamp(System.currentTimeMillis()));
        when(mockOffenseDao.getOffenseById(1)).thenReturn(null);
        when(mockOffenseDao.saveOffense(offenseToSave)).thenReturn(false);
        boolean result = offenseFacade.saveOffense(offenseToSave);

        assertFalse(result);
        verify(mockOffenseDao, times(1)).getOffenseById(1);
        verify(mockOffenseDao, times(1)).saveOffense(offenseToSave);
    }
}
