package com.cunningbird.thesis.backend.core.dto.response

data class ListAppointmentsResponse(
    var list: MutableList<OneAppointmentResponse> = mutableListOf(),
)
