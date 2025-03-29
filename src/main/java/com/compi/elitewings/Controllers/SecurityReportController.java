package com.compi.elitewings.Controllers;

import com.compi.elitewings.models.SecurityReport;
import com.compi.elitewings.service.IServiceSecurityReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;
@RestController
@RequestMapping("/security-reports")
public class SecurityReportController {
    @Autowired
    private IServiceSecurityReport serviceSecurityReport;

    @GetMapping("/")
    public List<SecurityReport> index() {return serviceSecurityReport.getAllReports();}
    @GetMapping("/security-reports/{id}")
    public SecurityReport getSecurityReport(@PathVariable("id") long id) {
        return this.serviceSecurityReport.getReport(id).orElse(null);
    }

    @PostMapping("/security-reports")
    public SecurityReport createSecurityReport(@RequestBody SecurityReport securityReport) {
        this.serviceSecurityReport.fileReport(securityReport);
        return securityReport;
    }

    @PatchMapping("/security-reports/{id}/resolve")
    public SecurityReport resolveSecurityReport(@PathVariable("id") long id) {
        return serviceSecurityReport.resolveReport(id).orElseThrow(() ->
                new RuntimeException("Security Report not found with id: " + id));
    }
}
