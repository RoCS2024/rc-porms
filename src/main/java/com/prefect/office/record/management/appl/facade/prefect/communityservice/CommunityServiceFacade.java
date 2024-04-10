package com.prefect.office.record.management.appl.facade.prefect.communityservice;

import com.prefect.office.record.management.appl.model.communityservice.CommunityService;

import java.util.List;

/**
 * An interface to the Community Service Facade.
 */
public interface CommunityServiceFacade {

    /**
     * Retrieves all community services from the database.
     *
     * @return list of all community services.
     */
    List<CommunityService> getAllCs();

    /**
     * Retrieves a community service from the database with the specified ID.
     *
     * @param id the ID of the community service.
     * @return the community service.
     */
    CommunityService getCsById(int id);

    /**
     * Renders a community service.
     *
     * @param cs the community service to render.
     * @return true if rendering is successful.
     */
    boolean renderCs(CommunityService cs);
}