package com.prefect.office.record.management.app.facade.prefect.offense.impl;

import com.prefect.office.record.management.app.model.offense.Offense;
import com.prefect.office.record.management.data.dao.prefect.offense.OffenseDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.sql.SQLException;
import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class OffenseFacadeImplTest {
    private OffenseFacadeImpl offenseFacade;
    @Mock
    private OffenseDao offenseDao;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        offenseFacade = new OffenseFacadeImpl(offenseDao);
    }

    @Test
    void testAddOffense_Success() throws SQLException {
        int violationId = 1;
        String studentId = "ct22-001";
        Timestamp offenseDate = Timestamp.valueOf("2022-01-01 00:00:00");

        Offense offense = new Offense();
        when(offenseDao.addOffense(offense)).thenReturn(true);

        boolean success = offenseFacade.saveOffense(offense);

        assertTrue(success);
        verify(offenseDao).addOffense(offense);
    }

    @Test
    void testAddOffense_Failure() throws SQLException {
        int violationId = 1;
        String studentId = "ct22-001";
        Timestamp offenseDate = Timestamp.valueOf("2022-01-01 00:00:00");

        Offense offense = new Offense();
        when(offenseDao.addOffense(offense)).thenReturn(false);

        boolean success = offenseFacade.saveOffense(offense);

        assertFalse(success);
        verify(offenseDao).addOffense(offense);
    }
}
