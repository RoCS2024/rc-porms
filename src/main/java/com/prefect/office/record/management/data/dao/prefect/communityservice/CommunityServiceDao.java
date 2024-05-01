package com.prefect.office.record.management.data.dao.prefect.communityservice;

import com.prefect.office.record.management.appl.model.communityservice.CommunityService;
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
     * Retrieves all community service records from the database with a specific student ID
     * @param studentId is the id of the Student that has a Community Service History
     * @return A list of all community service records of the specific student
     */
    List<CommunityService> getAllCsByStudentId(String studentId);

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
     */
    boolean renderCs(CommunityService cs);
}
