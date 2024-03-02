package com.view.history.data.communityservicehistory.dao;

import com.view.history.app.model.CommunityServiceHistory;
import com.view.history.app.model.Student;

import java.sql.SQLException;
import java.util.List;
public interface CommunityServiceHistoryDao {
    CommunityServiceHistory saveCommunityServiceHistory(CommunityServiceHistory communityservicehistory) throws SQLException;

    List<CommunityServiceHistory> getAllCommunityServiceHistory() throws SQLException;

    CommunityServiceHistory getCommunityServiceHistoryById(long id) throws SQLException;

    CommunityServiceHistory getId(String studentId);
}
