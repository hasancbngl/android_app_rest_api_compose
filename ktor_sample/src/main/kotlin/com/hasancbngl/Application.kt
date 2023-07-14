package com.hasancbngl

import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.html.*
import io.ktor.server.http.content.*
import io.ktor.server.plugins.callloging.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.html.*
import kotlinx.serialization.Serializable

//specify server engine
fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused")
fun Application.module() {
    //install call logging plugin
    //allows to show certain logging in ktor project
    install(CallLogging)
    install(ContentNegotiation) {
        json()
    }
    routing {
        //declare routing so our server should response to get request
        get("/") {
            call.respondText("Is it working?\n\nyees")
        }
        get("/users/{username}") {
            val username = call.parameters["username"]
            val header = call.request.headers["connection"]

            if (username == "hasan") {
                call.response.header("customHeader", "is it working?")
                call.respond(message = "Hello, $username, doing good with header:$header", status = HttpStatusCode.OK)
            } else call.respondText("user not found")
        }
        get("/user") {
            val name = call.request.queryParameters["name"]
            val age = call.request.queryParameters["age"]

            call.respondText("user: $name, age: $age", status = HttpStatusCode.OK)
        }
        get("/person") {
            try {
                val person = Person("john", 26)
                call.respond(message = person, status = HttpStatusCode.OK)
            } catch (e: Exception) {
                call.respond(message = "${e.message}", status = HttpStatusCode.BadRequest)
            }
        }
        get("/redirect") {
            call.respondRedirect("/person")
        }

        /*
         get request and basically same thing as above
         route(path = "/user", method = HttpMethod.Get){
               handle { call.respondText("longer function using route") }
           } */
        post("/p") {
            call.respondText("item posted")
        }
    }
}

@Suppress("unused")
fun Application.module2() {
    routing { //routing plugin
        //declare routing so our server should response to get request
        get("/test") {
            call.respondText("module2 response")
        }
    }
}

@Serializable
data class Person(
    val name: String,
    val age: Int
)

//static content and displaying resources
@Suppress("unused")
fun Application.module3() {
    routing {
        static {
            //adding static content resources
            /*   resource("ktor.html")
               resource("text.txt") */
            //or just specify a folder as static
            resources("static")
            get("/text") {
                call.respondRedirect("text.txt")
            }
            get("welcome") {
                call.respondHtml {
                    head {
                        title { +"custom title" }
                    }
                    body {
                        h1 { +"Just basic header" }
                        br { +"" }
                        p {
                            +"This is a beginning of a paragraph.custom directory is: ${
                                System.getProperty("user.dir")
                            }"
                        }
                        br { +"" }
                        h3 { +"H3 Title added" }
                        h3 { +"H3 Title added" }
                    }
                }
            }
            get("welcome2") {
                call.respondHtml {
                    head {
                        title { +"title" }
                    }
                }
            }
        }
    }
}