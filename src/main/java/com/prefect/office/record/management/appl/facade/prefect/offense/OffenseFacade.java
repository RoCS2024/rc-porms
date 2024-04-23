package com.prefect.office.record.management.appl.facade.prefect.offense;

import com.prefect.office.record.management.appl.model.offense.Offense;
import com.student.information.management.appl.model.student.Student;

import java.util.List;

public interface OffenseFacade {
    List<Offense> getAllOffenses();
    Offense getOffenseByID (int id);
    List<Offense> getAllOffenseByStudentId(Student studentId);
    boolean updateOffense (Offense offense);
    boolean addOffense(Offense offense);
}