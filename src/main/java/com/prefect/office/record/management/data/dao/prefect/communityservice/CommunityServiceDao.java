package com.prefect.office.record.management.data.dao.prefect.communityservice;

import com.prefect.office.record.management.appl.model.communityservice.CommunityService;

import java.sql.SQLException;
import java.util.List;

public interface CommunityServiceDao {
    List<CommunityService> getAllCs();
    CommunityService getCsById(int id);
    boolean renderCs(CommunityService cs) throws SQLException;
}
