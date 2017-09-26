package com.dinmab.kotlin.ahsfsreport.viewcontrollers

import com.dinmab.kotlin.ahsfsreport.database.RegionsDatabase
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class RegionsController {

    @Autowired
    private lateinit var database: RegionsDatabase

    @RequestMapping(value = "/regions")
    fun getRegions() = database.getRegions()
    
    @RequestMapping(value = "/")
    fun helloSpringBoot() = "Hello SpringBoot"
}