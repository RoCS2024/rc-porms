package com.prefect.office.record.management.appl.model.communityservice;

import java.sql.Timestamp;

/**
 * Represents a record of community service rendered by a student.
 */
public class CommunityService {

    private int id;

    private String student_id;

    private Timestamp date_rendered;

    private int hours_rendered;

    /**
     * Constructs a new CommunityService object with default values.
     */
    public CommunityService() {

    }

    /**
     * Constructs a new CommunityService object.
     *
     * @param id            The unique identifier of the community service record.
     * @param student_id    The ID of the student who rendered the service.
     * @param date_rendered The timestamp indicating the date and time of service.
     * @param hours_rendered The number of hours of community service rendered.
     */
    public CommunityService(int id, String student_id, Timestamp date_rendered, int hours_rendered) {
        this.id = id;
        this.student_id = student_id;
        this.date_rendered = date_rendered;
        this.hours_rendered = hours_rendered;
    }

    /**
     * Retrieves the unique identifier of the community service record.
     * @return The unique identifier of the community service record.
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the unique identifier of the community service record.
     * @param id The unique identifier to set.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Retrieves the ID of the student who rendered the community service.
     * @return The ID of the student.
     */
    public String getStudent_id() {
        return student_id;
    }

    /**
     * Sets the ID of the student who rendered the community service.
     * @param student_id The ID of the student to set.
     */
    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    /**
     * Retrieves the timestamp of when the community service was rendered.
     * @return The timestamp indicating the date and time.
     */
    public Timestamp getDate_rendered() {
        return date_rendered;
    }

    /**
     * Sets the timestamp indicating the date and time when the community service was rendered.
     * @param date_rendered The timestamp to set.
     */
    public void setDate_rendered(Timestamp date_rendered) {
        this.date_rendered = date_rendered;
    }

    /**
     * Retrieves the number of hours of community service rendered.
     * @return The number of hours rendered.
     */
    public int getHours_rendered() {
        return hours_rendered;
    }

    /**
     * Sets the number of hours of community service rendered.
     * @param hours_rendered The number of hours to set.
     */
    public void setHours_rendered(int hours_rendered) {
        this.hours_rendered = hours_rendered;
    }
}
