package com.dinmab.kotlin.ahsfsreport.viewcontrollers

import com.dinmab.kotlin.ahsfsreport.model.Violation
import com.dinmab.kotlin.ahsfsreport.repository.ViolationRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
class ViolationController {

    @Autowired
    lateinit var repository: ViolationRepository

    @RequestMapping(value = "/violations")
    fun getViolations() = repository.findAll()

    @RequestMapping(value = "/violation/{id}")
    fun getViolation(@PathVariable id: Long) = repository.findOne(id)

    @PutMapping(value = "/violation/{id}")
    fun putViolation(@PathVariable id: Long, @RequestBody violation: Violation): Violation {
        return repository.save(violation)
    }

    @PostMapping(value = "/violation")
    fun postViolation(@RequestBody violation: Violation): Violation {
        return repository.save(violation)
    }

    @DeleteMapping(value = "/violation/{id}")
    fun deleteViolation(@PathVariable id: Long) {
        return repository.delete(id)
    }
}