package com.dinmab.kotlin.ahsfsreport.repository

import com.dinmab.kotlin.ahsfsreport.model.Report
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ReportRepository : CrudRepository<Report, Long> {
}