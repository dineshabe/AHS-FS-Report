package com.dinmab.kotlin.ahsfsreport.model

import java.util.*

class Violation {
    var id: Long
    var reportId: Long
    var violation: String
    var requirement: String
    var comment: String
    var critical: Boolean

    constructor(id: Long,reportId: Long,violation: String, requirement: String, comment: String, critical: Boolean = false) {
        this.id = id
        this.reportId = reportId
        this.violation = violation
        this.requirement = requirement
        this.comment = comment
        this.critical = critical
    }
}