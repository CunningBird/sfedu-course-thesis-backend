package com.cunningbird.thesis.backend.identity

import com.cunningbird.thesis.backend.identity.config.AuthorizationServerConfig
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication

@SpringBootApplication
@EnableConfigurationProperties(AuthorizationServerConfig::class)
class Application

fun main(args: Array<String>) {
    runApplication<Application>(*args)
}
