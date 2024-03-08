package com.prefect.office.record.management.app.facade.prefect.communityservice.impl;

import com.prefect.office.record.management.app.model.communityservice.CommunityService;
import com.prefect.office.record.management.data.dao.prefect.communityservice.CommunityServiceDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CommunityServiceFacadeImplTest {

    @Mock
    private CommunityServiceDao communityServiceDaoMock;

    @InjectMocks
    private CommunityServiceFacadeImpl communityServiceFacade;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetAllCs() {
        List<CommunityService> expectedCommunityServices = new ArrayList<>();
        expectedCommunityServices.add(new CommunityService(1, "123", null, 10));
        expectedCommunityServices.add(new CommunityService(2, "456", null, 20));

        when(communityServiceDaoMock.getAllCs()).thenReturn(expectedCommunityServices);

        List<CommunityService> actualCommunityServices = communityServiceFacade.getAllCs();

        verify(communityServiceDaoMock, times(1)).getAllCs();
        assertEquals(expectedCommunityServices.size(), actualCommunityServices.size());
        for (int i = 0; i < expectedCommunityServices.size(); i++) {
            assertEquals(expectedCommunityServices.get(i), actualCommunityServices.get(i));
        }
    }

    @Test
    void testGetCsById() {
        int id = 1;
        CommunityService cs = new CommunityService(id, "123", null, 10);
        when(communityServiceDaoMock.getCsById(id)).thenReturn(cs);

        CommunityService result = communityServiceFacade.getCsById(id);

        assertTrue(result != null);
        assertTrue(result.getId() == id);
    }

    @Test
    void testRenderCs_Success() {
        CommunityService cs = new CommunityService(1, "123", null, 10);
        when(communityServiceDaoMock.getCsById(cs.getId())).thenReturn(cs);

        boolean result = communityServiceFacade.renderCs(cs);

        assertTrue(result);
        verify(communityServiceDaoMock, times(1)).getCsById(cs.getId());
    }

    @Test
    void testRenderCs_Failure() {
        CommunityService cs = new CommunityService(1, "123", null, 10);
        when(communityServiceDaoMock.getCsById(cs.getId())).thenReturn(null);

        boolean result = communityServiceFacade.renderCs(cs);

        assertFalse(result);
        verify(communityServiceDaoMock, times(1)).getCsById(cs.getId());
    }
}
