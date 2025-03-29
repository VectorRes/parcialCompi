package com.compi.elitewings.service;

import com.compi.elitewings.models.SecurityReport;
import com.compi.elitewings.repository.ISecurityReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SecurityReportService implements IServiceSecurityReport {

    private final ISecurityReportRepository securityReportRepository;

    @Autowired
    public SecurityReportService(ISecurityReportRepository securityReportRepository) {
        this.securityReportRepository = securityReportRepository;
    }

    @Override
    public SecurityReport fileReport(SecurityReport report) {
        return securityReportRepository.save(report);
    }

    @Override
    public List<SecurityReport> getUnresolvedReports() {
        return securityReportRepository.findByIsResolvedFalse();
    }

    @Override
    public Optional<SecurityReport> resolveReport(long id) {
        Optional<SecurityReport> optionalReport = securityReportRepository.findById(id);
        optionalReport.ifPresent(report -> {
            report.setResolved(true);
            securityReportRepository.save(report);
        });
        return optionalReport;
    }

    @Override
    public List<SecurityReport> getAllReports() {
        return securityReportRepository.findAll();
    }

    @Override
    public Optional<SecurityReport> getReport(long id) {
        return securityReportRepository.findById(id);
    }
}
