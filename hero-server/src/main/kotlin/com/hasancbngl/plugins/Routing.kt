package com.hasancbngl.plugins

import com.hasancbngl.routes.getAllHeroes
import com.hasancbngl.routes.root
import io.ktor.server.application.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    routing {
        //root '/' endpoint
        root()
        getAllHeroes()
    }
}
