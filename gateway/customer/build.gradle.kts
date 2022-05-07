import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "3.0.0-M2"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    kotlin("jvm") version "1.6.20-RC2"
    kotlin("plugin.spring") version "1.6.20-RC2"
}

group = "com.cunningbird.thesis.backend.gateway"
version = "0.0.1"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
    mavenCentral()
    maven { url = uri("https://repo.spring.io/milestone") }
}

extra["springCloudVersion"] = "2022.0.0-M2"

dependencies {
    // Kotlin
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.6.20")
    runtimeOnly("org.jetbrains.kotlin:kotlin-reflect:1.6.20")

    // Web
    implementation("org.springframework.cloud:spring-cloud-starter-gateway:3.1.1")

    // Security
    implementation("org.springframework.boot:spring-boot-starter-oauth2-resource-server:3.0.0-M1")
}

dependencyManagement {
    imports {
        mavenBom("org.springframework.cloud:spring-cloud-dependencies:${property("springCloudVersion")}")
    }
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "17"
    }
}