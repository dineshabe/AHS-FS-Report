package com.dinmab.kotlin.ahsfsreport.viewcontrollers

import com.dinmab.kotlin.ahsfsreport.model.Restaurent
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import com.dinmab.kotlin.ahsfsreport.repository.RestaurentRepository

@RestController
class RestaurentController {

    @Autowired
    lateinit var repository: RestaurentRepository

    @RequestMapping(value = "/restaurents")
    fun getRestaurents() : Iterable<Restaurent> {
      return repository.findAll()

    }

    @RequestMapping(value = "/findbyid/{id}")
    fun findById(@PathVariable id: Long) = repository.findOne(id)


    @RequestMapping(value = "/initData")
    fun initRestaurents() {
        repository.save( Restaurent("Test 1", "15753 blah blah", "restaurent", 1002))
        repository.save( Restaurent("Test 2", "15751 blah blah", "hotel", 1002))
        repository.save( Restaurent("Test 3", "15752 blah blah", "restaurent", 1002))
        repository.save( Restaurent("Test 4", "15754 blah blah", "pharmacy", 1002))
        repository.save( Restaurent("Test 5", "15755 blah blah", "store", 1002))

    }
}