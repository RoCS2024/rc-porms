package com.prefect.office.record.management.data.dao.prefect.communityservice;

import com.prefect.office.record.management.app.model.communityservice.CommunityService;

public interface CommunityServiceDao {
    CommunityService getCsById(int id);
    boolean renderCs(CommunityService cs);
}
