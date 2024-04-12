package com.prefect.office.record.management.data.dao.prefect.offense.impl;

import com.prefect.office.record.management.appl.facade.prefect.violation.ViolationFacade;
import com.prefect.office.record.management.appl.facade.prefect.violation.impl.ViolationFacadeImpl;
import com.prefect.office.record.management.appl.model.offense.Offense;
import com.prefect.office.record.management.appl.model.violation.Violation;
import com.prefect.office.record.management.data.connectionhelper.ConnectionHelper;
import com.prefect.office.record.management.data.dao.prefect.offense.OffenseDao;
import com.student.information.management.appl.facade.student.StudentFacade;
import com.student.information.management.appl.facade.student.impl.StudentFacadeImpl;
import com.student.information.management.appl.model.student.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 * This is an implementation class of the OffenseDao
 */
public class OffenseDaoImpl implements OffenseDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(OffenseDaoImpl.class);

    @Override
    public Offense getOffenseByID(int id) {
        String sql = "SELECT * FROM offense WHERE id = ?";
        try (Connection con = ConnectionHelper.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    int idNum = rs.getInt("id");
                    int violationId = rs.getInt("violation_id");
                    String studentId = rs.getString("student_id");

                    ViolationFacade violationFacade = new ViolationFacadeImpl();
                    StudentFacade studentFacade = new StudentFacadeImpl();

                    Violation violation = violationFacade.getViolationByID(violationId);
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
        String sql = "UPDATE offense SET violation_id = ?, student_id = ?, offense_date = ? WHERE id = ?";
        try (Connection con = ConnectionHelper.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

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
        String sql = "SELECT * FROM offense";
        try (Connection con = ConnectionHelper.getConnection();
             PreparedStatement statement = con.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Offense offense = new Offense();
                offense.setId(resultSet.getInt("id"));

                ViolationFacade violationFacade = new ViolationFacadeImpl();
                Violation violation = violationFacade.getViolationByID(resultSet.getInt("violation_id"));
                offense.setViolation(violation);

                StudentFacade studentFacade = new StudentFacadeImpl();
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
    public boolean addOffense(Offense offense) {
        String sql = "INSERT INTO offense (violation_id, student_id, offense_date) VALUES (?, ?, ?)";
        try (Connection con = ConnectionHelper.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, offense.getViolation().getId());
            stmt.setString(2, offense.getStudent().getStudentId());
            stmt.setTimestamp(3, offense.getOffenseDate());
            int affectedRows = stmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException ex) {
            String errorMessage = (ex.getMessage() != null) ? ex.getMessage() : "Unknown error";
            LOGGER.warn("Error adding offense: " + errorMessage);
            ex.printStackTrace();
            return false;
        }
    }
}
