package com.dinmab.kotlin.ahsfsreport.repository

import com.dinmab.kotlin.ahsfsreport.model.Violation
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ViolationRepository : CrudRepository<Violation, Long> {
}