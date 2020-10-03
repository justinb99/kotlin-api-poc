package justinb99.kotlinapipoc.service.model

import java.math.BigDecimal

data class Widget(
    val id: Int,
    val name: String,
    val price: BigDecimal,
    val quantityAvailable: Int
)
