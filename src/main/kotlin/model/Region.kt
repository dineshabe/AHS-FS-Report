package com.dinmab.kotlin.ahsfsreport.model

import javax.persistence.*

@Entity
@Table(name = "region")
class Region (val name: String, val detailedName: String, @Id @GeneratedValue(strategy = GenerationType.AUTO)
val id: Long = -1 ) {
    private constructor() : this("","") {
    }
}