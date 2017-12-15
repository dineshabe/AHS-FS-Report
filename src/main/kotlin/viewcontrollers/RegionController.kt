package com.dinmab.kotlin.ahsfsreport.viewcontrollers

import com.dinmab.kotlin.ahsfsreport.model.Region
import com.dinmab.kotlin.ahsfsreport.repository.RegionRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
class RegionController() {

    @Autowired
    lateinit var repository: RegionRepository

    @RequestMapping(value = "/regions")
    fun getRegions() = repository.findAll()

    @RequestMapping(value = "/region/{id}")
    fun getRegion(@PathVariable id: Long) = repository.findOne(id)

    @PutMapping(value = "/region/{id}")
    fun putRegion(@PathVariable id: Long, @RequestBody region: Region): Region {
        return repository.save(region)
    }

    @PostMapping(value = "/region")
    fun postRegion(@RequestBody region: Region): Region {
        return repository.save(region)
    }

    @DeleteMapping(value = "/region/{id}")
    fun deleteRegion(@PathVariable id: Long) {
        return repository.delete(id)
    }
}