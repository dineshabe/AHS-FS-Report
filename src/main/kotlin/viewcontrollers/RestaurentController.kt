package com.dinmab.kotlin.ahsfsreport.viewcontrollers

import com.dinmab.kotlin.ahsfsreport.database.RestaurentDatabase
import com.dinmab.kotlin.ahsfsreport.model.Restaurent
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class RestaurentController {

    @Autowired
    private lateinit var database: RestaurentDatabase

    @RequestMapping(value = "/restaurents")
    fun getRestaurents() : List<Restaurent> {
      return database.getRestaurent()
    }
}