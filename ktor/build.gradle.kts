plugins {
    application
}

application {
    mainClassName = "io.ktor.server.netty.EngineMain"
}

dependencies {
    val ktorVersion = "1.4.1"

    implementation(project(":service"))

    implementation("io.ktor:ktor-server-netty:$ktorVersion")
    implementation("io.ktor:ktor-server-core:$ktorVersion")
    implementation("io.ktor:ktor-locations:$ktorVersion")
    implementation("io.ktor:ktor-metrics:$ktorVersion")
    implementation("io.ktor:ktor-jackson:$ktorVersion")
    implementation("ch.qos.logback:logback-classic")

    runtimeOnly("org.postgresql:postgresql")

    testImplementation("io.ktor:ktor-server-tests:$ktorVersion")
}
