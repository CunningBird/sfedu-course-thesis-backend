package com.cunningbird.thesis.backend.core.controller.customer

import com.cunningbird.thesis.backend.core.dto.request.CreateAppointmentRequest
import com.cunningbird.thesis.backend.core.dto.response.ListAppointmentsResponse
import com.cunningbird.thesis.backend.core.dto.response.OneAppointmentResponse
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
        val response = ListAppointmentsResponse()
        service.getAppointmentsForCustomer(customerId).forEach { appointment ->
            response.list.add(
                OneAppointmentResponse(
                    appointment.id,
                    appointment.advertId,
                    appointment.customerId,
                    appointment.executorId,
                    appointment.appointmentDateTime,
                )
            )
        }
        return ResponseEntity(response, HttpStatus.OK)
    }

    @GetMapping("{appointmentId}")
    fun getAppointment(@RequestParam customerId: UUID, @PathVariable appointmentId: UUID): ResponseEntity<OneAppointmentResponse> {
        val appointment = service.getAppointmentForCustomer(customerId, appointmentId)
        val response = OneAppointmentResponse(
            appointment.id,
            appointment.advertId,
            appointment.customerId,
            appointment.executorId,
            appointment.appointmentDateTime,
        )
        return ResponseEntity(response, HttpStatus.OK)
    }

    @PostMapping("{advertId}")
    fun createAppointment(
        @RequestParam customerId: UUID,
        @PathVariable advertId: UUID,
        @RequestBody request: CreateAppointmentRequest
    ) {
        val date = request.date ?: throw Exception("Date is not set")
        service.createAppointment(customerId, advertId, date)
    }
}