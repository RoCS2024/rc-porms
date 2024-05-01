package com.prefect.office.record.management.data.dao.prefect.offense.impl;

import com.prefect.office.record.management.appl.facade.prefect.violation.ViolationFacade;
import com.prefect.office.record.management.appl.facade.prefect.violation.impl.ViolationFacadeImpl;
import com.prefect.office.record.management.appl.model.offense.Offense;
import com.prefect.office.record.management.appl.model.violation.Violation;
import com.prefect.office.record.management.data.connectionhelper.ConnectionHelper;
import com.prefect.office.record.management.data.dao.prefect.offense.OffenseDao;
import com.prefect.office.record.management.data.dao.prefect.violation.ViolationDao;
import com.prefect.office.record.management.data.dao.prefect.violation.impl.ViolationDaoImpl;
import com.student.information.management.StudentInfoMgtApplication;
import com.student.information.management.appl.facade.student.StudentFacade;
import com.student.information.management.appl.facade.student.impl.StudentFacadeImpl;
import com.student.information.management.appl.model.student.Student;
import com.student.information.management.data.student.dao.StudentDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.prefect.office.record.management.data.utils.QueryConstants.*;

/**
 * This is an implementation class of the OffenseDao
 */
public class OffenseDaoImpl implements OffenseDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(OffenseDaoImpl.class);

    @Override
    public Offense getOffenseByID(int id) {
        try (Connection con = ConnectionHelper.getConnection();
             PreparedStatement stmt = con.prepareStatement(GET_OFFENSE_BY_ID_STATEMENT)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    int idNum = rs.getInt("id");
                    int violationId = rs.getInt("violation_id");
                    String studentId = rs.getString("student_id");

                    ViolationDao violationDao = new ViolationDaoImpl();
                    ViolationFacade violationFacade = new ViolationFacadeImpl(violationDao);
                    Violation violation = violationFacade.getViolationByID(violationId);

                    StudentInfoMgtApplication app = new StudentInfoMgtApplication();
                    StudentFacade studentFacade = app.getStudentFacade();
                    Student student = studentFacade.getStudentById(studentId);

                    Timestamp offense_date = rs.getTimestamp("offense_date");
                    int commServHours = rs.getInt("comm_serv_hours");
                    return new Offense(idNum, violation, student, offense_date, commServHours);
                } else {
                    LOGGER.warn("No offense found with ID: " + id);
                }
            }
        } catch (SQLException ex) {
            LOGGER.warn("Error retrieving offense with ID " + id + ": " + ex.getMessage());
            ex.printStackTrace();
        }
        LOGGER.debug("Offense not found.");
        return null;
    }

    @Override
    public boolean updateOffense(Offense offense) {
        try (Connection con = ConnectionHelper.getConnection();
             PreparedStatement stmt = con.prepareStatement(UPDATE_OFFENSE_STATEMENT)) {

            Violation violation = offense.getViolation();
            Student student = offense.getStudent();

            stmt.setInt(1, violation.getId());
            stmt.setString(2, student.getStudentId());
            stmt.setTimestamp(3, offense.getOffenseDate());
            stmt.setInt(4, offense.getId());
            int affectedRows = stmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException ex) {
            LOGGER.warn("Error updating offense with ID " + offense.getId() + ": " + ex.getMessage());
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Offense> getAllOffenses() {
        List<Offense> offenses = new ArrayList<>();
        try (Connection con = ConnectionHelper.getConnection();
             PreparedStatement statement = con.prepareStatement(GET_ALL_OFFENSES_STATEMENT);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Offense offense = new Offense();
                offense.setId(resultSet.getInt("id"));

                ViolationDao violationDao = new ViolationDaoImpl();
                ViolationFacade violationFacade = new ViolationFacadeImpl(violationDao);
                Violation violation = violationFacade.getViolationByID(resultSet.getInt("violation_id"));
                offense.setViolation(violation);

                StudentInfoMgtApplication app = new StudentInfoMgtApplication();
                StudentFacade studentFacade = app.getStudentFacade();
                Student student = studentFacade.getStudentById(resultSet.getString("student_id"));
                offense.setStudent(student);

                offense.setOffenseDate(resultSet.getTimestamp("offense_date"));
                offense.setCommServHours(resultSet.getInt("comm_serv_hours"));
                offenses.add(offense);
            }
            LOGGER.info("Offenses retrieved successfully.");
        } catch (SQLException ex) {
            LOGGER.warn("Error retrieving all offenses: " + ex.getMessage());
            ex.printStackTrace();
        }
        LOGGER.debug("Offense database is empty.");
        return offenses;
    }

    @Override
    public List<Offense> getAllOffenseByStudent(Student studentId) {
        List<Offense> offenses = new ArrayList<>();
        try (Connection con = ConnectionHelper.getConnection();
             PreparedStatement statement = con.prepareStatement(GET_ALL_OFFENSES_BY_STUDENT_ID_STATEMENT)) {

            statement.setString(1, studentId.getStudentId());

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Offense offense = new Offense();
                    offense.setId(resultSet.getInt("id"));

                    ViolationDao violationDao = new ViolationDaoImpl();
                    ViolationFacade violationFacade = new ViolationFacadeImpl(violationDao);
                    Violation violation = violationFacade.getViolationByID(resultSet.getInt("violation_id"));
                    offense.setViolation(violation);

                    StudentInfoMgtApplication app = new StudentInfoMgtApplication();
                    StudentFacade studentFacade = app.getStudentFacade();
                    Student student = studentFacade.getStudentById(resultSet.getString("student_id"));
                    offense.setStudent(student);

                    offense.setOffenseDate(resultSet.getTimestamp("offense_date"));
                    offense.setCommServHours(resultSet.getInt("comm_serv_hours"));
                    offenses.add(offense);
                }
                LOGGER.info("Offenses retrieved successfully.");
            } catch (SQLException ex) {
                LOGGER.warn("Error retrieving all offenses: " + ex.getMessage());
                ex.printStackTrace();
            }
            LOGGER.debug("Offense database is empty.");
        } catch (SQLException ex) {
            LOGGER.warn("Error preparing statement: " + ex.getMessage());
            ex.printStackTrace();
        }
        return offenses;

    }


    @Override
    public boolean addOffense(Offense offense) {
        if (offense == null || offense.getViolation() == null || offense.getStudent() == null) {
            LOGGER.warn("Invalid offense object: " + offense);
            return false;
        }

        try (Connection con = ConnectionHelper.getConnection();
             PreparedStatement stmt = con.prepareStatement(ADD_OFFENSE_STATEMENT)) {
            Violation violation = offense.getViolation();
            int id = violation.getId();

            stmt.setInt(1, id);
            stmt.setString(2, offense.getStudent().getStudentId());
            stmt.setTimestamp(3, offense.getOffenseDate());
            int affectedRows = stmt.executeUpdate();
            //return affectedRows > 0;
            return true;
        } catch (SQLException ex) {
            LOGGER.warn("Error adding offense: " + ex.getMessage());
            ex.printStackTrace();
            return false;
        }
    }
}
