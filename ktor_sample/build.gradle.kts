import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.7.21"
    kotlin("plugin.serialization") version "1.9.0-Beta"
    application
}

group = "com.hasancbngl"
version = "0.0.1"

repositories {
    mavenCentral()
}

dependencies {
    //ktor
    implementation("io.ktor:ktor-server-core:2.2.2")
    implementation("io.ktor:ktor-server-netty:2.2.2")
    implementation("io.ktor:ktor-server-content-negotiation:2.2.2")
    implementation("io.ktor:ktor-serialization-kotlinx-json:2.2.2")
    //logback helps to see logs
    implementation("ch.qos.logback:logback-classic:1.4.5")
    implementation("io.ktor:ktor-server-call-logging-jvm:2.2.2")
    implementation("io.ktor:ktor-serialization:1.9.0-Beta")
    implementation("io.ktor:ktor-server-html-builder:2.2.2")
    //test
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

application {
    mainClass.set("io.ktor.server.netty.EngineMain")
}