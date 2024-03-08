package com.prefect.office.record.management.app.facade.prefect.communityservice.impl;

import com.prefect.office.record.management.app.facade.prefect.communityservice.CommunityServiceFacade;
import com.prefect.office.record.management.app.model.communityservice.CommunityService;
import com.prefect.office.record.management.data.dao.prefect.communityservice.CommunityServiceDao;
import com.prefect.office.record.management.data.dao.prefect.communityservice.impl.CommunityServiceDaoImpl;

import java.util.List;

public class CommunityServiceFacadeImpl implements CommunityServiceFacade {
    private final CommunityServiceDao communityServiceDao;

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
            CommunityService targetCs = getCsById(cs.getId());
            if(targetCs == null) {
                throw new IllegalArgumentException("Community Service to render not found.");
            }
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        } catch (Exception e) {
            throw new RuntimeException("Error rendering Community Service: " + e.getMessage(), e);
        }
    }

}
