package com.dinmab.kotlin.ahsfsreport.model

class Region {
    var id: Long
    var name: String
    var detailedName: String

    constructor(id: Long,name: String, detailedName: String) {
        this.id = id
        this.name = name
        this.detailedName = detailedName
    }
}