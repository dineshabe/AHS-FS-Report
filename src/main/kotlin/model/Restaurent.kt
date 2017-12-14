package com.dinmab.kotlin.ahsfsreport.model

import javax.persistence.*

@Entity
@Table(name = "restaurent")
class Restaurent (val name: String, val address: String, val type: String, zoneId: Long,@Id @GeneratedValue(strategy = GenerationType.AUTO)
val id: Long = -1 ) {
    private constructor(): this( "",  "",  "",  -1) {
    }
}