package com.prefect.office.record.management.app.facade.prefect.communityservice;

import com.prefect.office.record.management.app.model.communityservice.CommunityService;

public interface CommunityServiceFacade {
    CommunityService getCsById(int id);
    boolean renderCs(CommunityService cs);
}
