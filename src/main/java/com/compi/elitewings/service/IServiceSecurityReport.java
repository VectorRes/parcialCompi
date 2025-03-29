package com.compi.elitewings.service;

import com.compi.elitewings.models.SecurityReport;

import java.util.List;
import java.util.Optional;

public interface IServiceSecurityReport {
    SecurityReport fileReport(SecurityReport report);
    List<SecurityReport> getUnresolvedReports();
    Optional<SecurityReport> resolveReport(long id);
    List<SecurityReport> getAllReports();
    Optional<SecurityReport> getReport(long id);
}
