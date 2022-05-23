package com.cunningbird.thesis.backend.core.dto.response

import java.util.*

data class OneAppointmentResponse(
    var id: UUID? = null,
    var advertId: UUID? = null,
    var customerId: UUID? = null,
    val executorId: UUID? = null,
    var appointmentDateTime: Date? = null,
)