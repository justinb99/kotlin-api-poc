package justinb99.kotlinapipoc.service

import justinb99.kotlinapipoc.service.db.exposed.WidgetDao
import justinb99.kotlinapipoc.service.db.exposed.WidgetsTable
import justinb99.kotlinapipoc.service.model.CreateWidget
import justinb99.kotlinapipoc.service.model.Widget
import kotlinx.coroutines.Dispatchers
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.transactions.experimental.newSuspendedTransaction

class WidgetService {

    suspend fun createWidget(createWidget: CreateWidget): Widget =
        newSuspendedTransaction(Dispatchers.IO) {
            WidgetDao.new {
                name = createWidget.name
                price = createWidget.price
                quantityAvailable = createWidget.quantityAvailable
            }.toWidget()
        }

    private fun WidgetDao.toWidget(): Widget
     = Widget(
        id = this.id.value,
        name = this.name,
        price = this.price,
        quantityAvailable = this.quantityAvailable
    )
}
