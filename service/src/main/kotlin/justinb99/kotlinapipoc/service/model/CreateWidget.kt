package justinb99.kotlinapipoc.service.model

import java.math.BigDecimal

data class CreateWidget(
    val name: String,
    val price: BigDecimal,
    val quantityAvailable: Int
)
