package com.dinmab.kotlin.ahsfsreport.database

import org.springframework.stereotype.Component
import com.dinmab.kotlin.ahsfsreport.model.Region
import javax.annotation.PostConstruct

@Component
class RegionsDatabase {
    // All of our books will live here
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
                "North",
                detailedName = "North Zone"))
        regions.add(Region(
                "Edmonton",
                detailedName = "Edmonton & Area"))
        regions.add(Region(
                "Central",
                detailedName = "Red Deer & Camrose Area"))
        regions.add(Region(
                "Calgary",
                detailedName = "Calgary & Area"))
        regions.add(Region(
                "South",
                detailedName = "Lethbridge/Medicine Hat & Area"))
    }
}