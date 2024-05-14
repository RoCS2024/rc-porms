package com.prefect.office.record.management.data.utils;

/**
 * Inside the QueryConstants class contains constants representing SQL queries for managing prefect office system.
 */

public final class QueryConstants {

    /**
     * SQL query to retrieves all employees from the database.
     */
    public static final String GET_ALL_CS_STATEMENT = "SELECT * FROM comm_serv_rendered";

    /**
     * SQL query to retrieves all offenses by student id from the database.
     */
    public static final String GET_ALL_CS_BY_STUDENT_ID_STATEMENT = "SELECT * FROM comm_serv_rendered WHERE STUDENT_ID = ?";

    /**
     * SQL query to retrieves an CS by their Student Number from the database.
     */
    public static final String GET_CS_BY_ID_STATEMENT = "SELECT * FROM comm_serv_rendered WHERE id = ?";

    /**
     * SQL query to render the CS to the database.
     */
    public static final String RENDER_CS_STATEMENT = "INSERT INTO comm_serv_rendered (student_id, date_rendered, hours_rendered) VALUES (?, ?, ?)";


    /**
     * SQL query to retrieves all violation from the database.
     */
    public static final String GET_ALL_VIOLATION_STATEMENT = "SELECT * FROM violation";

    /**
     * SQL query to retrieves all violation by student id from the database.
     */
    public static final String GET_ALL_VIOLATION_BY_STUDENT_ID_STATEMENT = "SELECT * FROM violation WHERE STUDENT_ID = ?";

    /**
     * SQL query to retrieves a violation by their Student ID from the database.
     */
    public static final String GET_VIOLATION_BY_ID_STATEMENT = "SELECT * FROM violation WHERE id = ?";

    /**
     * SQL query to update an existing violation in the database.
     */
    public static final String UPDATE_VIOLATION_STATEMENT = "UPDATE violation SET student_id = ?, offense_id = ?, warning_number = ?, cs_hours = ?, disciplinary_action = ?, date_of_notice = ?, approved_by_id = ? WHERE id = ?";

    /**
     * SQL query that adds a new offense to the database.
     */
    public static final String ADD_VIOLATION_STATEMENT = "INSERT INTO violation (student_id, offense_id, warning_number, cs_hours, disciplinary_action, date_of_notice, approved_by_id) VALUES (?, ?, ?, ?, ?, ?, ?)";



    /**
     * SQL query that adds a new offense to the database.
     */
    public static final String ADD_OFFENSE_STATEMENT = "INSERT INTO offense (type, description) VALUES (?, ?)";

    /**
     * SQL query to retrieves all offense from the database.
     */
    public static final String GET_ALL_OFFENSE_STATEMENT = "SELECT * FROM offense";

    /**
     * SQL query to retrieve all offense by type from the database.
     */
    public static final String GET_ALL_OFFENSE_BY_TYPE_STATEMENT = "SELECT * FROM offense WHERE type = ?";

    /**
     * SQL query to retrieve an offense by their offense id from the database.
     */
    public static final String GET_OFFENSE_BY_ID_STATEMENT = "SELECT * FROM offense WHERE id = ?";

    /**
     * SQL query to retrieves an offense by their offense description or name from the database.
     */
    public static final String GET_OFFENSE_BY_NAME_STATEMENT = "SELECT * FROM offense WHERE description LIKE ?";

    /**
     * SQL query to update an existing offense in the database.
     */
    public static final String UPDATE_OFFENSE_STATEMENT ="UPDATE offense SET type = ?, description = ?, WHERE id = ?";
}
