package com.dinmab.kotlin.ahsfsreport.viewcontrollers

import com.dinmab.kotlin.ahsfsreport.model.Report
import com.dinmab.kotlin.ahsfsreport.repository.ReportRepository
import com.dinmab.kotlin.ahsfsreport.repository.RestaurentRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
class ReportController {

    @Autowired
    lateinit var repository: ReportRepository

    @RequestMapping(value = "/reports")
    fun getReports() = repository.findAll()

    @RequestMapping(value = "/report/{id}")
    fun getReport(@PathVariable id: Long) = repository.findOne(id)

    @PutMapping(value = "/report/{id}")
    fun putReport(@PathVariable id: Long, @RequestBody report: Report): Report {
        return repository.save(report)
    }

    @PostMapping(value = "/report")
    fun postReport(@RequestBody report: Report): Report {
        return repository.save(report)
    }

    @DeleteMapping(value = "/report/{id}")
    fun deleteReport(@PathVariable id: Long) {
        return repository.delete(id)
    }
}