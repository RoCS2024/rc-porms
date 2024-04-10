package com.prefect.office.record.management.data.dao.prefect.communityservice;

import com.prefect.office.record.management.appl.model.communityservice.CommunityService;

import java.sql.SQLException;
import java.util.List;

/**
 * Interface for accessing and managing community service records in the database.
 */
public interface CommunityServiceDao {

    /**
     * Retrieves all community service records from the database.
     *
     * @return A list of all community service records.
     */
    List<CommunityService> getAllCs();

    /**
     * Retrieves a specific community service record by its ID from the database.
     *
     * @param id The ID of the community service record to retrieve.
     * @return The community service record corresponding to the given ID.
     */
    CommunityService getCsById(int id);

    /**
     * Records a new community service entry into the database.
     *
     * @param cs The community service record to insert.
     * @return True if the insertion is successful, false otherwise.
     * @throws SQLException If an SQL exception occurs during the insertion process.
     */
    boolean renderCs(CommunityService cs) throws SQLException;
}
