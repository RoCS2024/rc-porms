package com.view.history.data.communityservicehistory.dao.impl;

import com.view.history.app.model.CommunityServiceHistory;
import com.view.history.data.communityservicehistory.dao.CommunityServiceHistoryDao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class CommunityServiceHistoryDaoImplTest {

    @Mock
    private Connection connection;

    @Mock
    private PreparedStatement preparedStatement;

    @Mock
    private ResultSet resultSet;

    private CommunityServiceHistoryDao communityServiceHistoryDao;

    @BeforeEach
    void setUp() throws SQLException {
        MockitoAnnotations.openMocks(this);
        communityServiceHistoryDao = new CommunityServiceHistoryDaoImpl() {
            @Override
            public CommunityServiceHistory saveCommunityServiceHistory(CommunityServiceHistory communityservicehistory) throws SQLException {
                return null;
            }

            @Override
            public List<CommunityServiceHistory> getAllCommunityServiceHistory() throws SQLException {
                return null;
            }

            @Override
            public CommunityServiceHistory getCommunityServiceHistoryById(long id) throws SQLException {
                return null;
            }

            @Override
            public Connection getConnection() {
                return connection;
            }
        };
    }

    @Test
    void testGetId() throws SQLException {
        String studentId = "123";
        String expectedId = "1";
        String expectedStudentId = "123";
        String expectedDateRendered = "2024-03-01";
        String expectedHoursRendered = "10";

        when(connection.prepareStatement(anyString())).thenReturn(preparedStatement);
        when(preparedStatement.executeQuery()).thenReturn(resultSet);
        when(resultSet.next()).thenReturn(true);
        when(resultSet.getString("id")).thenReturn(expectedId);
        when(resultSet.getString("Student_Id")).thenReturn(expectedStudentId);
        when(resultSet.getString("Date_Rendered")).thenReturn(expectedDateRendered);
        when(resultSet.getString("Hours_Rendered")).thenReturn(expectedHoursRendered);

        CommunityServiceHistory communityServiceHistory = communityServiceHistoryDao.getId(studentId);

        assertEquals(expectedId, communityServiceHistory.getId());
        assertEquals(expectedStudentId, communityServiceHistory.getStudentId());
        assertEquals(expectedDateRendered, communityServiceHistory.getDateRendered());
        assertEquals(expectedHoursRendered, communityServiceHistory.getHoursRendered());

        verify(preparedStatement).setString(1, studentId);
    }

    @Test
    void testGetIdNotFound() throws SQLException {
        String studentId = "123";

        when(connection.prepareStatement(anyString())).thenReturn(preparedStatement);
        when(preparedStatement.executeQuery()).thenReturn(resultSet);
        when(resultSet.next()).thenReturn(false);

        CommunityServiceHistory communityServiceHistory = communityServiceHistoryDao.getId(studentId);

        assertEquals(null, communityServiceHistory);

        verify(preparedStatement).setString(1, studentId);
    }
}
