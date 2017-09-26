package com.dinmab.kotlin.ahsfsreport

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean

fun main(args: Array<String>) {
    SpringApplication.run(App::class.java, *args)
}

@SpringBootApplication
open class App {

}