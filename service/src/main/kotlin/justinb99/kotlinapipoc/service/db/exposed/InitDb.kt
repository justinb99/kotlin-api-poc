package justinb99.kotlinapipoc.service.db.exposed

import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.Slf4jSqlDebugLogger
import org.jetbrains.exposed.sql.addLogger
import org.jetbrains.exposed.sql.transactions.transaction

fun initDb(
    host: String,
    port: String,
    db: String,
    user: String,
    password: String
) {
    Database.connect(
        url = "jdbc:postgresql://$host:$port/$db",
        driver = "org.postgresql.Driver",
        user = user,
        password = password
    )

    transaction {
        addLogger(Slf4jSqlDebugLogger)
        SchemaUtils.create(WidgetsTable)
    }
}