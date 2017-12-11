package com.dinmab.kotlin.ahsfsreport.database

import org.springframework.stereotype.Component
import com.dinmab.kotlin.ahsfsreport.model.Region
import javax.annotation.PostConstruct

@Component
class RegionsDatabase {
    private val regions = mutableListOf<Region>()

    fun getRegions() = regions

    fun addRegion(region: Region): Boolean {
        regions.firstOrNull { it.name == region.name }?.let {
            return false
        }
        regions.add(region)
        return true
    }

    @PostConstruct
    private fun init() {
        // Fill our "database"
        regions.add(Region(
                id = 1001,
                name = "North",
                detailedName = "North Zone"))
        regions.add(Region(
                id = 1002,
                name = "Edmonton",
                detailedName = "Edmonton & Area"))
        regions.add(Region(
                id = 1003,
                name = "Central",
                detailedName = "Red Deer & Camrose Area"))
        regions.add(Region(
                id = 1004,
                name = "Calgary",
                detailedName = "Calgary & Area"))
        regions.add(Region(
                id = 1005,
                name = "South",
                detailedName = "Lethbridge/Medicine Hat & Area"))
    }
}