package com.dinmab.kotlin.ahsfsreport.repository

import com.dinmab.kotlin.ahsfsreport.model.Region
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface RegionRepository : CrudRepository<Region, Long> {
}