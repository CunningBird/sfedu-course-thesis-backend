import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "2.6.3"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    kotlin("jvm") version "1.6.10"
    kotlin("plugin.spring") version "1.6.10"
}

group = "com.cunningbird.thesis.backend"
version = "0.0.1"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
    mavenCentral()
    maven { url = uri("https://repo.spring.io/milestone") }
}

dependencies {
    // Kotlin
    implementation("io.projectreactor.kotlin:reactor-kotlin-extensions:1.1.5")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.13.1")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.6.10")
    runtimeOnly("org.jetbrains.kotlin:kotlin-reflect:1.6.10")
    runtimeOnly("org.jetbrains.kotlinx:kotlinx-coroutines-reactor:1.6.0")

    // Web
    implementation("org.springframework.boot:spring-boot-starter-webflux")

    // Persistence
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.postgresql:postgresql:42.3.3")
    implementation ("org.flywaydb:flyway-core:8.5.2")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "11"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
