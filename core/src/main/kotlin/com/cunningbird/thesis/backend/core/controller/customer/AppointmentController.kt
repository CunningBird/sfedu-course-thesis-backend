package com.cunningbird.thesis.backend.core.controller.customer

import com.cunningbird.thesis.backend.core.dto.request.CreateAppointmentRequest
import com.cunningbird.thesis.backend.core.dto.response.ListAppointmentsResponse
import com.cunningbird.thesis.backend.core.dto.response.OneAppointmentResponse
import com.cunningbird.thesis.backend.core.service.AppointmentService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException
import java.util.*

@RestController("CustomerAppointmentController")
@RequestMapping("customer/appointments")
class AppointmentController(
    private val service: AppointmentService
) {

    @GetMapping
    fun getAppointments(@RequestHeader("customer_id") customerId: UUID): ResponseEntity<ListAppointmentsResponse> {
        try {
            return ResponseEntity(service.getAppointmentsForCustomer(customerId), HttpStatus.OK)
        } catch (e: Exception) {
            throw ResponseStatusException(HttpStatus.BAD_REQUEST, e.message, e)
        }
    }

    @GetMapping("{appointmentId}")
    fun getAppointment(
        @RequestHeader("customer_id") customerId: UUID,
        @PathVariable appointmentId: UUID
    ): ResponseEntity<OneAppointmentResponse> {
        try {
            return ResponseEntity(service.getAppointmentForCustomer(customerId, appointmentId), HttpStatus.OK)
        } catch (e: Exception) {
            throw ResponseStatusException(HttpStatus.BAD_REQUEST, e.message, e)
        }
    }

    @PostMapping("{advertId}")
    fun createAppointment(
        @RequestHeader("customer_id") customerId: UUID,
        @PathVariable advertId: UUID,
        @RequestBody request: CreateAppointmentRequest
    ) {
        try {
            service.createAppointment(customerId, advertId, request)
        } catch (e: Exception) {
            throw ResponseStatusException(HttpStatus.BAD_REQUEST, e.message, e)
        }
    }
}