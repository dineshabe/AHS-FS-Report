package com.dinmab.kotlin.ahsfsreport.model

class Region {
    var name: String
    var detailedName: String

    constructor(name: String, detailedName: String) {
        this.name = name
        this.detailedName = detailedName
    }
}