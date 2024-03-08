package com.prefect.office.record.management.data.dao.prefect.communityservice.impl;

import com.prefect.office.record.management.app.model.communityservice.CommunityService;
import com.prefect.office.record.management.data.connectionhelper.ConnectionHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class CommunityServiceDaoImplTest {

    @Mock
    private Connection connection;

    @Mock
    private PreparedStatement preparedStatement;

    @Mock
    private ResultSet resultSet;

    @InjectMocks
    private CommunityServiceDaoImpl communityServiceDao;

    @BeforeEach
    void setUp() throws SQLException {
        MockitoAnnotations.openMocks(this);
        when(connection.prepareStatement(any(String.class))).thenReturn(preparedStatement);
    }

    @Test
    void testGetAllCs() throws SQLException {
        when(preparedStatement.executeQuery()).thenReturn(resultSet);
        when(resultSet.next()).thenReturn(true).thenReturn(false);
        when(resultSet.getInt("id")).thenReturn(1);
        when(resultSet.getString("student_id")).thenReturn("S001");
        when(resultSet.getTimestamp("date_rendered")).thenReturn(Timestamp.valueOf("2024-03-08 10:00:00"));
        when(resultSet.getInt("hours_rendered")).thenReturn(5);

        List<CommunityService> communityServices = communityServiceDao.getAllCs();

        assertNotNull(communityServices);
        assertEquals(1, communityServices.size());
        assertEquals(1, communityServices.get(0).getId());
        assertEquals("S001", communityServices.get(0).getStudent_id());
        assertEquals(Timestamp.valueOf("2024-03-08 10:00:00"), communityServices.get(0).getDate_rendered());
        assertEquals(5, communityServices.get(0).getHours_rendered());
    }

    @Test
    void testGetCsById() throws SQLException {
        when(preparedStatement.executeQuery()).thenReturn(resultSet);
        when(resultSet.next()).thenReturn(true);
        when(resultSet.getInt("id")).thenReturn(1);
        when(resultSet.getString("student_id")).thenReturn("S001");
        when(resultSet.getTimestamp("date_rendered")).thenReturn(Timestamp.valueOf("2024-03-08 10:00:00"));
        when(resultSet.getInt("hours_rendered")).thenReturn(5);

        CommunityService communityService = communityServiceDao.getCsById(1);

        assertNotNull(communityService);
        assertEquals(1, communityService.getId());
        assertEquals("S001", communityService.getStudent_id());
        assertEquals(Timestamp.valueOf("2024-03-08 10:00:00"), communityService.getDate_rendered());
        assertEquals(5, communityService.getHours_rendered());
    }

    @Test
    void testRenderCs() throws SQLException {
        CommunityService cs = new CommunityService(1, "S001", Timestamp.valueOf("2024-03-08 10:00:00"), 5);

        when(preparedStatement.executeUpdate()).thenReturn(1);

        boolean result = communityServiceDao.renderCs(cs);

        assertTrue(result);
        verify(preparedStatement).setString(1, "S001");
        verify(preparedStatement).setTimestamp(2, Timestamp.valueOf("2024-03-08 10:00:00"));
        verify(preparedStatement).setInt(3, 5);
        verify(preparedStatement).setInt(4, 1);
        verify(preparedStatement).executeUpdate();
    }
}
