package com.prefect.office.record.management.data.dao.prefect.communityservice.impl;

import com.prefect.office.record.management.appl.model.communityservice.CommunityService;
import com.prefect.office.record.management.appl.model.offense.Offense;
import com.prefect.office.record.management.data.dao.prefect.communityservice.CommunityServiceDao;
import com.student.information.management.appl.model.student.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


class CommunityServiceDaoImplTest {
    private CommunityServiceDao communityServiceDao;
    private List<CommunityService> communityServices;

    @BeforeEach
    public void setUp() {
        communityServices = new ArrayList<>();
        CommunityService communityService1 = new CommunityService();
        CommunityService communityService2 = new CommunityService();
        communityServices.add(communityService1);
        communityServices.add(communityService2);

        communityServiceDao = mock(CommunityServiceDao.class);
    }

    @Test
    public void testGetAllCs() {
        when(communityServiceDao.getAllCs()).thenReturn(communityServices);
        List<CommunityService> communityServiceList = communityServiceDao.getAllCs();
        assertEquals(communityServiceList.size(), 2);
    }

    @Test
    public void testGetCsById() {
        CommunityService communityService1 = new CommunityService();
        communityService1.setId(1);

        when(communityServiceDao.getCsById(1)).thenReturn(communityService1);

        CommunityService expectedCommunityService = communityServiceDao.getCsById(1);

        assertEquals(expectedCommunityService, communityService1);
        assertEquals(expectedCommunityService.getId(), communityService1.getId());
    }
    @Test
    public void testRenderCs() {
        CommunityService communityService = new CommunityService();
        communityService.setId(1);

        try {
            when(communityServiceDao.renderCs(communityService)).thenReturn(true);
            when(communityServiceDao.getCsById(1)).thenReturn(communityService);

            CommunityService expectedCommunityService = communityServiceDao.getCsById(1);
            assertEquals(expectedCommunityService.getId(), communityService.getId());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testGetAllCsByStudentId() {
        Student student1 = new Student();
        student1.setStudentId("CT21-0001");

        CommunityService communityService = new CommunityService();
        communityService.setStudent(student1);

        when(communityServiceDao.getAllCsByStudent(student1)).thenReturn(communityServices);
        List<CommunityService> communityServiceList = communityServiceDao.getAllCsByStudent(student1);
        assertEquals(communityServiceList.size(), 2);
    }
}