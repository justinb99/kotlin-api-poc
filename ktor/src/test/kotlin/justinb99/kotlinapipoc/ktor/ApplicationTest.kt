package justinb99.kotlinapipoc.ktor

import io.kotest.core.spec.style.StringSpec
import io.ktor.http.*
import io.ktor.server.testing.*
import kotlin.test.assertEquals

class ApplicationTest : StringSpec({

    "test Root" {
        withTestApplication({ module(testing = true) }) {
            handleRequest(HttpMethod.Get, "/").apply {
                assertEquals(HttpStatusCode.OK, response.status())
                assertEquals("HELLO WORLD!", response.content)
            }
        }
    }
})
