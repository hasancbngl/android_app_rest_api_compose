package com.hasancbngl.routes

import com.hasancbngl.models.ApiResponse
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import java.lang.NumberFormatException

fun Route.getAllHeroes() {
    get("/heroes") {
        try {
            val page = call.request.queryParameters["page"]?.toInt() ?: 1
            //require the page only be within 1-5 otherwise throw an exception
            require(page in 1..5)
            call.respond(message = page)
        } catch (e: NumberFormatException) {
            call.respond(
                message = ApiResponse(
                    success = false,
                    message = "Invalid Page.Only numbers allowed."
                ),
                status = HttpStatusCode.BadRequest
            )
        } catch (e: Exception) {
            call.respond(
                message = ApiResponse(
                    success = false,
                    message = "Heroes not found"
                ),
                status = HttpStatusCode.NotFound
            )
        }
    }
}