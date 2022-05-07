pluginManagement {
    repositories {
        maven { url = uri("https://repo.spring.io/milestone") }
        gradlePluginPortal()
    }
}

rootProject.name = "thesis-backend"

// Identity
include("identity")

// Facades
include("gateway:customer")
include("gateway:executor")

// Backend
include("core")

