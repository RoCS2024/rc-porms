package com.prefect.office.record.management.app.facade.prefect.communityservice;

import com.prefect.office.record.management.app.model.communityservice.CommunityService;

import java.util.List;

public interface CommunityServiceFacade {
    List<CommunityService> getAllCs();
    CommunityService getCsById(int id);
    boolean renderCs(CommunityService cs);
}
