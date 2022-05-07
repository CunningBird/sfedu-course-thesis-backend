package com.cunningbird.thesis.backend.identity.entity

import java.util.*
import javax.persistence.*

/**
 * Пользователь
 */
@Entity
@Table(name = "users")
data class User(

    @Id
    @GeneratedValue
    @Column(name = "id", unique = true, nullable = false)
    private var id: UUID? = null,

    @Column(name = "username", unique = true, nullable = false)
    var username: String? = null,

    @Column(name = "email", unique = true, nullable = false)
    var email: String? = null,

    @Column(name = "password", nullable = false)
    var password: String? = null,

    @Column(name = "first_name")
    var firstName: String? = null,

    @Column(name = "last_name")
    var lastName: String? = null
)