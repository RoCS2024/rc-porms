package com.prefect.office.record.management.data.dao.prefect.offense.impl;

import com.prefect.office.record.management.app.model.offense.Offense;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class OffenseDaoImplTest {

    private OffenseDaoImpl offenseDao;
    @Mock
    private Connection connection;
    @Mock
    private PreparedStatement preparedStatement;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        offenseDao = new OffenseDaoImpl(connection);
    }

    @Test
    public void testAddOffense_Success() throws SQLException {

        Offense offense = new Offense(1, "ct22-001", Timestamp.valueOf("2022-01-01 00:00:00"));

        when(connection.prepareStatement(any(String.class))).thenReturn(preparedStatement);
        when(preparedStatement.executeUpdate()).thenReturn(1);

        boolean success = offenseDao.addOffense(offense);

        verify(connection, times(1)).prepareStatement(any(String.class));
        verify(preparedStatement, times(1)).executeUpdate();

        assertTrue(success);
    }

    @Test
    public void testAddOffense_Failure() throws SQLException {

        Offense offense = new Offense(1, "ct22-001", Timestamp.valueOf("2022-01-01 00:00:00"));

        when(connection.prepareStatement(any(String.class))).thenReturn(preparedStatement);
        when(preparedStatement.executeUpdate()).thenReturn(0);

        boolean success = offenseDao.addOffense(offense);

        verify(connection, times(1)).prepareStatement(any(String.class));
        verify(preparedStatement, times(1)).executeUpdate();

        assertFalse(success);
    }
}
