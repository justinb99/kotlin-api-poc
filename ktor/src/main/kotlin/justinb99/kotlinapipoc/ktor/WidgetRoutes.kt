package justinb99.kotlinapipoc.ktor

import io.ktor.application.*
import io.ktor.http.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*
import justinb99.kotlinapipoc.service.WidgetService
import justinb99.kotlinapipoc.service.model.CreateWidget

fun Route.widgetRoutes(widgetService: WidgetService) {
    post("/widgets") {
        val createWidget = call.receive<CreateWidget>()
        val result = widgetService.createWidget(createWidget)
        call.respond(HttpStatusCode.Companion.Created, result)
    }

//    get("/widgets/{id}") {
//
//    }
}