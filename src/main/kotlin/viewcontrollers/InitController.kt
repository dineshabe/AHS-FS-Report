package com.dinmab.kotlin.ahsfsreport.viewcontrollers

import com.dinmab.kotlin.ahsfsreport.model.Region
import com.dinmab.kotlin.ahsfsreport.model.Report
import com.dinmab.kotlin.ahsfsreport.model.Restaurent
import com.dinmab.kotlin.ahsfsreport.model.Violation
import com.dinmab.kotlin.ahsfsreport.repository.RegionRepository
import com.dinmab.kotlin.ahsfsreport.repository.ReportRepository
import com.dinmab.kotlin.ahsfsreport.repository.RestaurentRepository
import com.dinmab.kotlin.ahsfsreport.repository.ViolationRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
class InitController {

    @Autowired
    lateinit var restaurentRepository: RestaurentRepository

    @Autowired
    lateinit var regionRepository: RegionRepository

    @Autowired
    lateinit var reportRepository: ReportRepository

    @Autowired
    lateinit var violationRepository: ViolationRepository

    @RequestMapping(value = "/initRestaurents")
    fun initRestaurents() {
        restaurentRepository.save( Restaurent("Test 1", "15753 blah blah", "restaurent", 1002))
        restaurentRepository.save( Restaurent("Test 2", "15751 blah blah", "hotel", 1002))
        restaurentRepository.save( Restaurent("Test 3", "15752 blah blah", "restaurent", 1002))
        restaurentRepository.save( Restaurent("Test 4", "15754 blah blah", "pharmacy", 1002))
        restaurentRepository.save( Restaurent("Test 5", "15755 blah blah", "store", 1002))
    }


    @RequestMapping(value = "/initRegions")
    fun initRegions() {
        regionRepository.save( Region("Calgary-YYC", "Calgary"))
        regionRepository.save( Region("Fort McMurray", "North Alberta"))
        regionRepository.save( Region("NoClue", "Central Alberta"))
        regionRepository.save( Region("Edmonton-yvr", "Edmonton"))
        regionRepository.save( Region("Southern Alberta", "Lethbridge"))
    }


    @RequestMapping(value = "/initReports")
    fun initReports() {
        reportRepository.save( Report(Date(), "Violation",1001,"Close this place"))
        reportRepository.save( Report(Date(), "Appreciation",1002,"Dont Close this place"))
        reportRepository.save( Report(Date(), "Open",1003,"Open this place"))
        reportRepository.save( Report(Date(), "BAAD",1004,"Burn this place"))
        reportRepository.save( Report(Date(), "Congrats",1005,"this place rocks"))
    }


    @RequestMapping(value = "/initViolations")
    fun initViolations() {
        violationRepository.save( Violation(1001, "Not right temperture", "Food needs to be stored in right temperature", "Needs to fix fridge", true))
        violationRepository.save( Violation(1002, "Not right place", "Food needs to be stored in right place", "Needs to fix the place", false))
        violationRepository.save( Violation(1003, "Not right disinfectant", "Food needs to be stored in right temperature", "Needs to fix the disinfectant", true))
        violationRepository.save( Violation(1004, "Not right dish washer", "Dishwasher needs to be right kind", "Needs to fix dishwasher", true))
        violationRepository.save( Violation(1005, "Not clean", "Food needs to be stored in clean place", "Needs to addend training", true))
    }

    @RequestMapping(value = "/")
    fun helloSpringBoot() = "Welcome"
}