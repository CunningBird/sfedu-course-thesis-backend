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
    var id: UUID? = null,

    var advertId: UUID? = null,
    var customerId: UUID? = null,
    var executorId: UUID? = null,

    var appointmentDateTime: Date? = null,
)
