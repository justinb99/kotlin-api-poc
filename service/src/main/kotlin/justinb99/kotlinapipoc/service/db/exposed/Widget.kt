package justinb99.kotlinapipoc.service.db.exposed

import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable

object WidgetsTable : IntIdTable() {
    val name = varchar("name", 50)
    val price = decimal("price", 10, 2)
    val quantityAvailable = integer("quantityAvailable")
}

class WidgetDao(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<WidgetDao>(WidgetsTable)

    var name by WidgetsTable.name
    var price by WidgetsTable.price
    var quantityAvailable by WidgetsTable.quantityAvailable
}
