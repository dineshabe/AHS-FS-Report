package com.dinmab.kotlin.ahsfsreport.model

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType

@Entity
@Table(name = "violation")
class Violation (val reportId: Long, val violation: String, val requirement: String, val comment: String, val critical: Boolean, @Id @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long = -1) {
        private constructor() : this(-1, "", "", "", false)
}