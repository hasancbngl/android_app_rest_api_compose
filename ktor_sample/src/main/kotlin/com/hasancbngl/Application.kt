package com.hasancbngl

import io.ktor.server.application.*
import io.ktor.server.plugins.callloging.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.slf4j.event.*

//specify server engine
fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused")
fun Application.module() {
    routing {
        //declare routing so our server should response to get request
        get("/") {
            call.respondText("Is it working?\n\nyees")
        }
    }
}

@Suppress("unused")
fun Application.module2() {
    //install call logging plugin
    install(CallLogging)
    routing { //routing plugin
        //declare routing so our server should response to get request
        get("/test") {
            call.respondText("module2 response")
        }
    }
}