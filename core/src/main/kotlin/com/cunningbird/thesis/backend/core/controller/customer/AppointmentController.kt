package com.cunningbird.thesis.backend.core.controller.customer

import com.cunningbird.thesis.backend.core.dto.response.appointment.ListAppointmentsResponse
import com.cunningbird.thesis.backend.core.dto.response.appointment.OneAppointmentResponse
import com.cunningbird.thesis.backend.core.service.AppointmentService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController("CustomerAppointmentController")
@RequestMapping("customer/appointments")
class AppointmentController(
    private val service: AppointmentService
) {

    @GetMapping
    fun getAppointments(@RequestParam customerId: UUID): ResponseEntity<ListAppointmentsResponse> {

        val response = ListAppointmentsResponse(UUID.randomUUID())
        return ResponseEntity(response, HttpStatus.OK)
    }

    @GetMapping("{appointmentId}")
    fun getAppointment(@RequestParam customerId: UUID, @PathVariable appointmentId: UUID): ResponseEntity<OneAppointmentResponse?> {

        val response = OneAppointmentResponse(UUID.randomUUID())
        return ResponseEntity(response, HttpStatus.OK)
    }
}