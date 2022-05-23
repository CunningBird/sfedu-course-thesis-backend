package com.cunningbird.thesis.backend.core.controller.executor

import com.cunningbird.thesis.backend.core.dto.response.ListAppointmentsResponse
import com.cunningbird.thesis.backend.core.dto.response.OneAppointmentResponse
import com.cunningbird.thesis.backend.core.service.AppointmentService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException
import java.util.*

@RestController("ExecutorAppointmentController")
@RequestMapping("executor/appointments")
class AppointmentController(
    private val service: AppointmentService
) {

    @GetMapping("/")
    fun getAppointments(@RequestParam executorId: UUID): ResponseEntity<ListAppointmentsResponse> {
        try {
            return ResponseEntity(service.getAppointmentsForExecutor(executorId), HttpStatus.OK)
        } catch (e: Exception) {
            throw ResponseStatusException(HttpStatus.BAD_REQUEST, e.message, e)
        }
    }

    @GetMapping("{appointmentId}")
    fun getAppointment(
        @RequestParam executorId: UUID,
        @PathVariable appointmentId: UUID
    ): ResponseEntity<OneAppointmentResponse> {
        try {
            return ResponseEntity(service.getAppointmentForExecutor(executorId, appointmentId), HttpStatus.OK)
        } catch (e: Exception) {
            throw ResponseStatusException(HttpStatus.BAD_REQUEST, e.message, e)
        }
    }
}