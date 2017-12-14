package com.dinmab.kotlin.ahsfsreport.model

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "report")
class Report (val date: Date, val type: String, val restaurentId: Long, val action: String, @Id @GeneratedValue(strategy = GenerationType.AUTO)
val id: Long = -1 ) {
    private constructor() : this(Date(), "", -1, "") {
    }
}