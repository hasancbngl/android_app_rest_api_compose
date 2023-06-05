package com.hasancbngl

import io.ktor.http.*
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
        get("/users/{username}") {
            val username = call.parameters["username"]
            val header = call.request.headers["connection"]

            if (username=="hasan") {
                call.response.header("customHeader" , "is it working?")
                call.respond(message = "Hello, $username, u doing good", status = HttpStatusCode.OK)
            } else call.respondText("user not found")
        }
        get("/user") {
            call.respondText("user page", status = HttpStatusCode.OK)
        }

     /*
      get request and basically same thing as above
      route(path = "/route", method = HttpMethod.Get){
            handle { call.respondText("longer function using route") }
        } */
        post ("/p"){
            call.respondText("item posted")
        }
    }
}

@Suppress("unused")
fun Application.module2() {
    //install call logging plugin
    //plugin allows to show certain logging in ktor project
    install(CallLogging)
    routing { //routing plugin
        //declare routing so our server should response to get request
        get("/test") {
            call.respondText("module2 response")
        }
    }
}