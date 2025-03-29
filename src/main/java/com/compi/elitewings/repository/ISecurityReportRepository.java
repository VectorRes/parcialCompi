package com.compi.elitewings.repository;

import com.compi.elitewings.models.Celebrity;
import com.compi.elitewings.models.SecurityReport;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ISecurityReportRepository extends JpaRepository<SecurityReport, Long> {
    List<SecurityReport> findByIsResolvedFalse();
}
