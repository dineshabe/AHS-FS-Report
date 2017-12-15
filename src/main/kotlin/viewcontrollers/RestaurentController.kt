package com.dinmab.kotlin.ahsfsreport.viewcontrollers

import com.dinmab.kotlin.ahsfsreport.model.Restaurent
import org.springframework.beans.factory.annotation.Autowired
import com.dinmab.kotlin.ahsfsreport.repository.RestaurentRepository
import org.springframework.web.bind.annotation.*

@RestController
class RestaurentController {

    @Autowired
    lateinit var repository: RestaurentRepository

    @RequestMapping(value = "/restaurents")
    fun getRestaurents() = repository.findAll()

    @RequestMapping(value = "/restaurent/{id}")
    fun getRestaurent(@PathVariable id: Long) = repository.findOne(id)

    @PutMapping(value = "/restaurent/{id}")
    fun putRestaurent(@PathVariable id: Long, @RequestBody restaurent: Restaurent): Restaurent {
        return repository.save(restaurent)
    }

    @PostMapping(value = "/restaurent")
    fun postRestaurent(@RequestBody restaurent: Restaurent): Restaurent {
        return repository.save(restaurent)
    }

    @DeleteMapping(value = "/restaurent/{id}")
    fun deleteRestaurent(@PathVariable id: Long) {
        return repository.delete(id)
    }
}