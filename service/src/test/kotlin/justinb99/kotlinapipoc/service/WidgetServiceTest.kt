package justinb99.kotlinapipoc.service

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldNotBe

class WidgetServiceTest : StringSpec({

    "WidgetService should instantiate" {
        val service = WidgetService()
        service shouldNotBe null
    }

})