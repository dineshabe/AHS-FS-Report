package com.dinmab.kotlin.ahsfsreport.model

import java.util.*

class Report {
    var id: Long
    var date: Date
    var type: String
    var restaurentId: Long
    var action: String
    var violations = mutableListOf<Violation>()

    constructor(id: Long,date: Date,type: String, restaurentId: Long, action: String) {
        this.id = id
        this.date = date
        this.type = type
        this.restaurentId = restaurentId
        this.action = action
    }
}