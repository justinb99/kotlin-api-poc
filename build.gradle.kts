plugins {
    kotlin("jvm") version "1.4.10"
    idea
}

group = "com.github.justinb99"
version = "1.0-SNAPSHOT"

idea {
    module {
        outputDir = file("build/classes/main")
        testOutputDir = file("build/classes/test")
    }
}

allprojects {
    repositories {
        mavenLocal()
        mavenCentral()
    }
}

subprojects {
    apply<JavaBasePlugin>()
    apply<org.jetbrains.kotlin.gradle.plugin.KotlinPlatformJvmPlugin>()
    apply<IdeaPlugin>()

    java {
        sourceCompatibility = JavaVersion.VERSION_15
        targetCompatibility = JavaVersion.VERSION_15
    }

    dependencies {
        constraints {
            implementation("ch.qos.logback:logback-classic:1.2.1")
        }

        kotlin("stdlib")

        testImplementation("io.kotest:kotest-runner-junit5:4.2.5") // for kotest framework
        testImplementation("io.kotest:kotest-assertions-core:4.2.5") // for kotest core jvm assertions
        testImplementation("io.kotest:kotest-property:4.2.5") // for kotest property test
    }

    tasks {
        withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
            kotlinOptions {
                freeCompilerArgs = listOf(
                        "-Xjsr305=strict",  // Support Java nullability
                        "-Xjvm-default=enable"  // Enable declaration of Java default methods
                )
                jvmTarget = "14"
            }
        }

        test {
            useJUnitPlatform()
        }
    }
}

tasks {
    wrapper {
        gradleVersion = "6.6.1"
//        distributionType = Wrapper.DistributionType.ALL
    }
}
