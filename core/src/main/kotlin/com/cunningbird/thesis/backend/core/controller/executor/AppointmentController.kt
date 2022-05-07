package com.cunningbird.thesis.backend.core.controller.executor

import com.cunningbird.thesis.backend.core.dto.request.appointment.UpdateAppointmentRequest
import com.cunningbird.thesis.backend.core.dto.response.appointment.OneAppointmentResponse
import com.cunningbird.thesis.backend.core.dto.response.appointment.PerDayAppointmentsResponse
import com.cunningbird.thesis.backend.core.dto.response.appointment.PerMonthAppointmentsResponse
import com.cunningbird.thesis.backend.core.service.AppointmentService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController("ExecutorAppointmentController")
@RequestMapping("executor/appointments")
class AppointmentController(
    private val service: AppointmentService
) {

    @GetMapping("/perMonth")
    fun getAppointmentsPerMonth(@RequestParam executorId: UUID): ResponseEntity<PerMonthAppointmentsResponse> {

        val response = PerMonthAppointmentsResponse(UUID.randomUUID())
        return ResponseEntity(response, HttpStatus.OK)
    }

    @GetMapping("/perDay")
    fun getAppointmentsPerDay(@RequestParam executorId: UUID): ResponseEntity<PerDayAppointmentsResponse> {

        val response = PerDayAppointmentsResponse(UUID.randomUUID())
        return ResponseEntity(response, HttpStatus.OK)
    }

    @GetMapping("{appointmentId}")
    fun getAppointment(@RequestParam executorId: UUID, @PathVariable appointmentId: UUID): ResponseEntity<OneAppointmentResponse?> {

        val response = OneAppointmentResponse(UUID.randomUUID())
        return ResponseEntity(response, HttpStatus.OK)
    }

    @PatchMapping("{appointmentId}")
    fun updateAppointment(@RequestParam executorId: UUID, @PathVariable appointmentId: UUID, @RequestBody appointment: UpdateAppointmentRequest) {

    }

    @PostMapping
    fun crateAppointment(@RequestParam executorId: UUID, @RequestBody appointment: UpdateAppointmentRequest) {

    }
}