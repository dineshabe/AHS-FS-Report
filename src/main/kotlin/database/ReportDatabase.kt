package com.dinmab.kotlin.ahsfsreport.database

import org.springframework.stereotype.Component
import com.dinmab.kotlin.ahsfsreport.model.Report
import org.springframework.beans.factory.annotation.Autowired
import java.util.*
import javax.annotation.PostConstruct

@Component
class ReportDatabase {
    private val reports = mutableListOf<Report>()

    @Autowired
    private lateinit var violationDatabase: ViolationDatabase

    fun getReports() = reports

    fun getReports(restaurentId: Long): MutableList<Report> {
        var restaurentReports = reports.filter { it.restaurentId == restaurentId }.toMutableList()

        for (report in restaurentReports) {
            report.violations = violationDatabase.getViolations(reportId = report.id).toMutableList()
        }
        return restaurentReports
    }

    fun addReport(region: Report): Boolean {
        reports.firstOrNull { it.id == region.id }?.let {
            return false
        }
        reports.add(region)
        return true
    }

    @PostConstruct
    private fun init() {
        // Fill our "database"
        reports.add(Report(
                id = 1001,
                date = Date(),
                type = "Monitoring Inspection/Routine",
                restaurentId = 1001,
                action = "Consultation, Inspection Report"))
        reports.add(Report(
                id = 1002,
                date = Date(),
                type = "Monitoring Inspection/Routine",
                restaurentId = 1002,
                action = "Approval Granted, Inspection Report"))
        reports.add(Report(
                id = 1003,
                date = Date(),
                type = "Risk Management/Re-Inspection",
                restaurentId = 1003,
                action = "Approval Denied, Inspection Report"))
        reports.add(Report(
                id = 1004,
                date = Date(),
                type = "Risk Management/Re-Inspection",
                restaurentId = 1004,
                action = "Approval Denied, Inspection Report"))
        reports.add(Report(
                id = 1005,
                date = Date(),
                type = "Initial Inspection/Approval",
                restaurentId = 1005,
                action = "Approval Denied, Inspection Report"))
    }
}