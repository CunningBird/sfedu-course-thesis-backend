package com.cunningbird.thesis.backend.core.entity.appointment

import java.util.*
import javax.persistence.Column
import javax.persistence.GeneratedValue
import javax.persistence.Id

data class Appointment(

    @Id
    @GeneratedValue
    @Column(name = "id", unique = true, nullable = false)
    private var id: UUID? = null,

    private var serviceId: UUID? = null,
    private var customerId: UUID? = null,

    private val appointmentDateTime: Date? = null,

    private val clientName: String? = null,
    private val phoneNumber: String? = null,

    private val customerNote: String? = null,
    private val executorNote: String? = null
)
