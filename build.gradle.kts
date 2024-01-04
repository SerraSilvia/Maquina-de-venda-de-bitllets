plugins {
    kotlin("jvm") version "1.9.0"
    id("org.jetbrains.dokka") version "1.9.10"
    application
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    dokkaHtmlPlugin("org.jetbrains.dokka:kotlin-as-java-plugin:1.9.10")
}

tasks.dokkaHtml.configure {
    outputDirectory.set(buildDir.resolve("dokka"))
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(8)
}

application {
    mainClass.set("MainKt")
}