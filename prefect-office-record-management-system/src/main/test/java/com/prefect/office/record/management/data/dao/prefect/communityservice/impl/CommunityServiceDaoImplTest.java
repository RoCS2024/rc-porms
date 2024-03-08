package com.prefect.office.record.management.data.dao.prefect.communityservice.impl;

import com.prefect.office.record.management.app.model.communityservice.CommunityService;
import com.prefect.office.record.management.data.connectionhelper.ConnectionHelper;
import com.prefect.office.record.management.data.dao.prefect.communityservice.CommunityServiceDao;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CommunityServiceDaoImplTest {

    @Mock
    private Connection connectionMock;

    @Mock
    private PreparedStatement preparedStatementMock;

    @Mock
    private ResultSet resultSetMock;

    @InjectMocks
    private CommunityServiceDaoImpl communityServiceDao;

    @Test
    void testGetCsById() throws Exception {
        MockitoAnnotations.initMocks(this);

        int id = 1;
        String studentId = "123";
        Timestamp dateRendered = new Timestamp(System.currentTimeMillis());
        int hoursRendered = 10;
        CommunityService expectedCommunityService = new CommunityService(id, studentId, dateRendered, hoursRendered);

        when(ConnectionHelper.getConnection()).thenReturn(connectionMock);
        when(connectionMock.prepareStatement(anyString())).thenReturn(preparedStatementMock);
        when(preparedStatementMock.executeQuery()).thenReturn(resultSetMock);
        when(resultSetMock.next()).thenReturn(true);
        when(resultSetMock.getInt("id")).thenReturn(id);
        when(resultSetMock.getString("student_id")).thenReturn(studentId);
        when(resultSetMock.getTimestamp("date_rendered")).thenReturn(dateRendered);
        when(resultSetMock.getInt("hours_rendered")).thenReturn(hoursRendered);

        CommunityService actualCommunityService = communityServiceDao.getCsById(id);

        assertNotNull(actualCommunityService);
        assertEquals(expectedCommunityService, actualCommunityService);
    }

    @Test
    void testGetCsById_NotFound() throws Exception {
        MockitoAnnotations.initMocks(this);

        int id = 1;

        when(ConnectionHelper.getConnection()).thenReturn(connectionMock);
        when(connectionMock.prepareStatement(anyString())).thenReturn(preparedStatementMock);
        when(preparedStatementMock.executeQuery()).thenReturn(resultSetMock);
        when(resultSetMock.next()).thenReturn(false);

        CommunityService actualCommunityService = communityServiceDao.getCsById(id);

        assertNull(actualCommunityService);
    }

    @Test
    void testRenderCs_Success() throws Exception {
        MockitoAnnotations.initMocks(this);

        CommunityService cs = new CommunityService(1, "123", new Timestamp(System.currentTimeMillis()), 10);
        String sql = "UPDATE comm_serv_rendered SET student_id = ?, date_rendered = ?, hours_rendered = ? WHERE id = ?";

        when(ConnectionHelper.getConnection()).thenReturn(connectionMock);
        when(connectionMock.prepareStatement(sql)).thenReturn(preparedStatementMock);
        when(preparedStatementMock.executeUpdate()).thenReturn(1);

        boolean result = communityServiceDao.renderCs(cs);

        assertTrue(result);
    }

    @Test
    void testRenderCs_Failure() throws Exception {
        MockitoAnnotations.initMocks(this);

        CommunityService cs = new CommunityService(1, "123", new Timestamp(System.currentTimeMillis()), 10);
        String sql = "UPDATE comm_serv_rendered SET student_id = ?, date_rendered = ?, hours_rendered = ? WHERE id = ?";

        when(ConnectionHelper.getConnection()).thenReturn(connectionMock);
        when(connectionMock.prepareStatement(sql)).thenReturn(preparedStatementMock);
        when(preparedStatementMock.executeUpdate()).thenThrow(new RuntimeException("Failed to execute"));

        boolean result = communityServiceDao.renderCs(cs);

        assertFalse(result);
    }
}

