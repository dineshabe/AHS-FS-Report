package com.dinmab.kotlin.ahsfsreport.database

import org.springframework.stereotype.Component
import com.dinmab.kotlin.ahsfsreport.model.Violation
import javax.annotation.PostConstruct

@Component
class ViolationDatabase {
    private val violations = mutableListOf<Violation>()

    fun getViolations() = violations

    fun getViolations(reportId: Long) = violations.filter { it.reportId == reportId }

    fun addRestaurent(region: Violation): Boolean {
        violations.firstOrNull { it.id == region.id }?.let {
            return false
        }
        violations.add(region)
        return true
    }

    @PostConstruct
    private fun init() {
        // Fill our "database"
        violations.add(Violation(
                id = 1001,
                reportId = 1001,
                violation = "Does the operator use approved methods for cleaning and sanitizing equipment, utensils, and surfaces?",
                requirement = "CLEAN IN PLACE SURFACES AND EQUIPMENT - Equipment and food contact surfaces are not being cleaned and sanitized properly. A commercial food establishment, all equipment and utensils in it and all surfaces in it with which food comes into contact must be maintained in a sanitary condition and, with out limiting the foregoing, must be washed and sanitized in a manner that removes contamination. AR 31/2006 s 28(2)",
                comment = "1) NO CHLORINE WAS DETECTED IN THE SANITIZER SPRAY BOTTLE.\n" +
                        "1) USE 100PPM CHLORINE AND MAKE SANITIZER ONCE A WEEK TO MAINTAIN SANITIZER STRENGTH AT 100PPM.",
                critical =  true))

        violations.add(Violation(
                id = 1002,
                reportId = 1002,
                violation = "Are food temperatures during storage and processing being controlled to maximize food safety?",
                requirement = "REFRIGERATION OF FOODS - Foods under refrigeration are not being maintained at or below 4 C. High risk foods must be kept at a temperature of less than 4*C or greater than 60*C at all times. AR 31/2006 s 25(1)",
                comment = "1) MAGIC CHEF COOLER WAS MEASURED AT 9.3 DEGREES C.\n" +
                        "1) FIX ADJUST COOLER DIAL AND STORE ALL PERISHABLE FOODS AT 4 DEGREES C. OR BELOW.",
                critical =  true))

        violations.add(Violation(
                id = 1003,
                reportId = 1003,
                violation = "Do food handlers at the facility have adequate food safety training (Non-Critical)?",
                requirement = "FOOD SAFETY TRAINING - At least one person having care and control of this food establishment does not hold a certificate in food sanitation and/or is not on site when 6 or more food handlers are working. A manager/supervisor must have approved food safety training. If 6 or more staff are working, the trained manager/supervisor must be on site. Owners of more than one site must have a different trained manager for each site. AR 31/2006 s 31",
                comment = "CONTACT JOAN ENG FUNG FOR FOOD SAFETY REQUIREMENTS AT 403-943-2295.",
                critical =  false))

        violations.add(Violation(
                id = 1004,
                reportId = 1004,
                violation = "Are there adequate and properly operating dish washing facilities to effectively clean and sanitize equipment and utensils (unless noted elsewhere) (Non-Critical)?",
                requirement = "REQUIRED SINKS - The number of sinks in the food establishment is inadequate for the type/level of food preparation. An operator shall ensure that a commercial food establishment is so designed as to facilitate the effective cleaning and sanitizing of it and all equipment, utensils and surfaces with which food comes in to contact in it. AR 31/2006 s 17(1)\n" +
                        "TESTING EQUIPMENT - Chemical testing equipment is not available for measuring sanitizing agent concentrations and/or an adequate thermometer is not available for measuring water temperatures. A commercial food establishment must have all the facilities, equipment and utensils that are necessary to ensure its safe operation and maintenance and all equipment and utensils in it and all surfaces in it with which food comes into contact must be maintained in a sanitary condition and, without limiting the foregoing, must be washed and sanitized in a manner that removes contamination. AR 31/2006 s 28(1) & (2)",
                comment = "1. THERE IS ONLY A ONE COMPARTMENT STAINLESS STEEL SINK AVAILABLE.\n" +
                        "2. CHLORINE TEST STRIPS ARE NOT AVAILABLE.\n" +
                        "1. MINIMUM 2 COMPARTMENT SINK IS REQUIRED.\n" +
                        "2. OBTAIN CHLORINE TEST STRIPS. 100 PPM SOLUTION IS REQUIRED FOR SANITIZING.",
                critical =  false))

        violations.add(Violation(
                id = 1005,
                reportId = 1005,
                violation = "Is the facility properly constructed and maintained in a state of good repair to allow for the safe and sanitary handling of food (Non-Critical)?",
                requirement = "WALLS - Wall surfaces are unsuitable, unsatisfactory, or in disrepair. An operator shall ensure that a food establishment is of sound construction and in a good state of repair and is so designed as to facilitate the effective cleaning and sanitizing of it and all equipment, utensils and surfaces with which food comes into contact in it. AR 31/2006 s 17(1) & 19\n" +
                        "FLOORS - Floor surfaces are unsuitable, unsatisfactory, or in disrepair. An operator shall ensure that a food establishment is of sound construction and in a good state of repair and is so designed as to facilitate the effective cleaning and sanitizing of it and all equipment, utensils and surfaces with which food comes into contact in it. AR 31/2006 s 17(1) & 19",
                comment = "1. BASEBOARDS HAVE NOT BEEN INSTALLED.\n" +
                        "2. TOE KICKS ARE NOT INSTALLED ON CABINETRY.\n" +
                        "1&2 ENSURE ALL FINISHES ARE INSTALLED SO THAT ALL SURFACES ARE SMOOTH, IMPERVIOUS TO MOISTURE AND EASILY CLEANED.",
                critical =  true))
    }
}