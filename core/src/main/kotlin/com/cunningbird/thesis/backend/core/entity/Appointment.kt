package com.cunningbird.thesis.backend.core.entity

import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class Appointment(

    @Id
    @GeneratedValue
    @Column(name = "id", unique = true, nullable = false)
    private var id: UUID? = null,

    private var serviceId: UUID? = null,
    private var customerId: UUID? = null,

    private val appointmentDateTime: Date? = null,

    private val phoneNumber: String? = null,
)
