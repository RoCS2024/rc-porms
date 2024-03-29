package com.prefect.office.record.management.appl.facade.prefect.communityservice.impl;

import com.prefect.office.record.management.appl.facade.prefect.communityservice.CommunityServiceFacade;
import com.prefect.office.record.management.appl.model.communityservice.CommunityService;
import com.prefect.office.record.management.data.dao.prefect.communityservice.CommunityServiceDao;
import com.prefect.office.record.management.data.dao.prefect.communityservice.impl.CommunityServiceDaoImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static org.mockito.Mockito.*;

class CommunityServiceFacadeImplTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(CommunityServiceFacadeImplTest.class);

    @InjectMocks
    private CommunityServiceFacade communityServiceFacade = new CommunityServiceFacadeImpl(new CommunityServiceDaoImpl());

    @Mock
    private CommunityServiceDao communityServiceDao;

    @Mock
    private List<CommunityService> communityServiceList;

    @Mock
    private CommunityService communityService;

    @Mock
    private CommunityService addCommunityService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        communityService.setId(1);
        addCommunityService.setId(2);
        when(communityServiceDao.getAllCs()).thenReturn(communityServiceList);
    }

    @AfterEach
    public void validate() {
        validateMockitoUsage();
    }

    @Test
    public void testGetAllCs() {
        List expectedList = communityServiceFacade.getAllCs();

        assert (expectedList.equals(communityServiceList));

        verify(communityServiceDao).getAllCs();
    }

    @Test
    public void testGetCsById() {
        when(communityServiceDao.getCsById(1)).thenReturn(communityService);
        CommunityService expectedCommunityService = communityServiceFacade.getCsById(1);

        assert (expectedCommunityService.equals(communityService));

        verify(communityServiceDao).getCsById(1);
    }

    @Test
    public void testRenderCs() {
        try {
            when(communityServiceDao.getCsById(communityService.getId())).thenReturn(communityService);
            when(communityServiceDao.renderCs(communityService)).thenReturn(true);

            boolean result = communityServiceFacade.renderCs(communityService);

            assert (result == true);

            assert (communityServiceFacade.getCsById(1).equals(communityService));

            verify(communityServiceDao).renderCs(communityService);
        } catch (Exception e) {
            LOGGER.error("Exception caught: " + e.getMessage());
        }
    }
}