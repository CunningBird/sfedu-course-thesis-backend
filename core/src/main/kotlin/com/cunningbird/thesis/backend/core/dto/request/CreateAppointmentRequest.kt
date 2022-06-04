package com.cunningbird.thesis.backend.core.dto.request

import java.util.*

data class CreateAppointmentRequest(
    var date: Date? = null,
)