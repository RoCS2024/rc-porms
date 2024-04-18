package com.prefect.office.record.management.appl.facade.prefect.communityservice.impl;

import com.prefect.office.record.management.appl.facade.prefect.communityservice.CommunityServiceFacade;
import com.prefect.office.record.management.appl.model.communityservice.CommunityService;
import com.prefect.office.record.management.data.dao.prefect.communityservice.CommunityServiceDao;

import java.util.List;

/**
 * An implementation class of the Community Service Facade.
 */
public class CommunityServiceFacadeImpl implements CommunityServiceFacade {
    private CommunityServiceDao communityServiceDao;
    public CommunityServiceFacadeImpl(CommunityServiceDao communityServiceDao) {
        this.communityServiceDao = communityServiceDao;
    }
    @Override
    public List<CommunityService> getAllCs() {
        return communityServiceDao.getAllCs();
    }

    @Override
    public CommunityService getCsById(int id) {
        return communityServiceDao.getCsById(id);
    }

    @Override
    public boolean renderCs(CommunityService cs) {
        try {
            return communityServiceDao.renderCs(cs);
        } catch (Exception e) {
            throw new RuntimeException("Error rendering Community Service: " + e.getMessage(), e);
        }
    }

}
