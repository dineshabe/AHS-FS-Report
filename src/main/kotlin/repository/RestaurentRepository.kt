package com.dinmab.kotlin.ahsfsreport.repository

import com.dinmab.kotlin.ahsfsreport.model.Restaurent
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface RestaurentRepository : CrudRepository<Restaurent, Long> {
}