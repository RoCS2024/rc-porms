package com.prefect.office.record.management.app.facade.prefect.communityservice.impl;

import com.prefect.office.record.management.app.facade.prefect.communityservice.CommunityServiceFacade;
import com.prefect.office.record.management.app.model.communityservice.CommunityService;
import com.prefect.office.record.management.data.dao.prefect.communityservice.CommunityServiceDao;
import com.prefect.office.record.management.data.dao.prefect.communityservice.impl.CommunityServiceDaoImpl;

public class CommunityServiceFacadeImpl implements CommunityServiceFacade {
    CommunityServiceDao communityServiceDao = new CommunityServiceDaoImpl();

    public CommunityServiceFacadeImpl(CommunityServiceDao communityServiceDao){

    }

    @Override
    public CommunityService getCsById(int id) {
        return communityServiceDao.getCsById(id);
    }

    @Override
    public boolean renderCs(CommunityService cs) {
        boolean result = false;
        try {
            CommunityService targetCs = getCsById(cs.getId());
            if(targetCs == null) {
                throw new Exception("Community Service to render not found. ");
            }
            result = communityServiceDao.renderCs(cs);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        return result;
    }
}
