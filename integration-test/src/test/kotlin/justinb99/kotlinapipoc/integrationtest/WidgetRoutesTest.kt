package justinb99.kotlinapipoc.integrationtest

import io.kotest.core.spec.Spec
import io.kotest.core.spec.style.StringSpec
import io.kotest.core.test.Description
import io.kotest.matchers.ints.shouldBeGreaterThan
import io.kotest.matchers.shouldBe
import io.restassured.RestAssured
import io.restassured.RestAssured.given
import io.restassured.http.ContentType
import org.hamcrest.Matchers.equalTo
import org.hamcrest.Matchers.greaterThan
import java.math.BigDecimal

class WidgetRoutesTest : StringSpec({

    "service should create a widget" {
        val createWidget = mapOf(
            "name" to "computer",
            "price" to "1000.00",
            "quantityAvailable" to "100"
        )

        val id: Int = given()
            .contentType(ContentType.JSON)
            .body(createWidget)
            .post("/widgets")
            .then()
            .statusCode(201)
            .body("name", equalTo("computer"))
            .body("price", equalTo(1000.0f))
            .body("quantityAvailable", equalTo(100))
            .extract()
            .path("id")

        id shouldBeGreaterThan 0
    }

}) {
    override fun beforeSpec(spec: Spec) {
        super.beforeSpec(spec)

        RestAssured.baseURI = "http://localhost"
        RestAssured.port = 8080
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails()
    }
}