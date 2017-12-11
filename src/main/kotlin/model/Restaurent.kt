package com.dinmab.kotlin.ahsfsreport.model
class Restaurent {
    var id: Long
    var name: String
    var address: String
    var type: String
    var zoneId: Long
    var reports = mutableListOf<Report>()

    constructor(id: Long,zoneId: Long,name: String, address: String, type: String) {
        this.id = id
        this.zoneId = zoneId
        this.name = name
        this.address = address
        this.type = type
    }
}