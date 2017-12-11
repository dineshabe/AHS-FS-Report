package com.dinmab.kotlin.ahsfsreport.database

import org.springframework.stereotype.Component
import com.dinmab.kotlin.ahsfsreport.model.Restaurent
import org.springframework.beans.factory.annotation.Autowired
import javax.annotation.PostConstruct

@Component
class RestaurentDatabase {
    private val restaurents = mutableListOf<Restaurent>()

    @Autowired
    private lateinit var reportDatabase: ReportDatabase

    fun getRestaurent(): List<Restaurent> {
        for (restaurent in restaurents) {
            restaurent.reports = reportDatabase.getReports(restaurentId = restaurent.id).toMutableList()
        }
        return restaurents
    }

    fun getRestaurent(id: Long): Restaurent {
        var restaurent = restaurents.filter { it.id == id }.first()

        restaurent.reports = reportDatabase.getReports(restaurentId = restaurent.id).toMutableList()

        return restaurent
    }

    fun addRestaurent(region: Restaurent): Boolean {
        restaurents.firstOrNull { it.id == region.id }?.let {
            return false
        }
        restaurents.add(region)
        return true
    }

    @PostConstruct
    private fun init() {
        // Fill our "database"
        restaurents.add(Restaurent(
                id = 1001,
                zoneId = 1001,
                name = "#1 Convenience Store",
                address = "924 Edmonton Trail NE" +
                        "Calgary AB T2E 3K1 ",
                type = "Convenience Store"))
        restaurents.add(Restaurent(
                id = 1002,
                zoneId = 1002,
                name = "1 Cup Coffee Club CGY-932",
                address = "320 Centre Avenue NE" +
                        "Airdrie AB T4B 2B8 ",
                type = "Type A (Pre-packaged)"))
        restaurents.add(Restaurent(
                id = 1003,
                zoneId = 1003,
                name = "101 Pharmacy",
                address = "1107 Centre Street NW" +
                        "Calgary AB T2E 2R1 ",
                type = "Convenience Store\n"))
        restaurents.add(Restaurent(
                id = 1004,
                zoneId = 1004,
                name = "1600 World Bier Haus",
                address = "A100 - 1600 90 Avenue SW" +
                        "Calgary AB T2V 5A8 ",
                type = "Restaurant"))
        restaurents.add(Restaurent(
                id = 1005,
                zoneId = 1005,
                name = "1906 - Bar",
                address = "134B Macleod Trail SW" +
                        "High River AB T1V 1P6 ",
                type = "Lounge / Bar"))
    }
}