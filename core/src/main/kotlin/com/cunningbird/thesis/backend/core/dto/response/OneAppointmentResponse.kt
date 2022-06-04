package com.cunningbird.thesis.backend.core.dto.response

import java.util.*

data class OneAppointmentResponse(
    var id: UUID? = null,
    var advertName: String? = null,
    var advertImage: String? = null,
    var date: Date? = null,
)