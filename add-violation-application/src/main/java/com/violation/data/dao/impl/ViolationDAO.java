package com.violation.data.dao.impl;

import com.violation.app.model.item.Violation;

import java.util.List;

public interface ViolationDAO {
    void addViolation(Violation violation);
    void updateViolation(Violation violation);
    List<Violation> getAllViolations();
}
