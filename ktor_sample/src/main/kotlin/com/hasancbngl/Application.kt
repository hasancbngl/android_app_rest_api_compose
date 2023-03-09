package com.hasancbngl

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

//specify server engine
fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)


fun Application.module() {
    routing {
        //declare routing so our server should response to get request
        get("/") {
            call.respondText("Is it working?\n\nyees")
        }
    }
}