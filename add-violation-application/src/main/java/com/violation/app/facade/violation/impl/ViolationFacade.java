package com.violation.app.facade.violation.impl;

import com.violation.app.model.item.Violation;

import java.util.List;

public interface ViolationFacade {
    void addViolation(String violation, String type, int commServHours);
}