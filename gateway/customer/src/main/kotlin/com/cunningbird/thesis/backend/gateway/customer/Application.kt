package com.cunningbird.thesis.backend.gateway.customer

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class Application

fun main(args: Array<String>) {
    runApplication<Application>(*args)
}

// TODO Contract with clients

// TODO Enable Web Security

// TODO Exclude Swagger from auth

// TODO Validate accessToken in WebSecurityFilter

// TODO Connect to BFB using gRPC