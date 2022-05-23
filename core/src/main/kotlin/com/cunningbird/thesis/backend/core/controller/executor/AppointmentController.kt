package com.cunningbird.thesis.backend.core.controller.executor

import com.cunningbird.thesis.backend.core.dto.response.ListAppointmentsResponse
import com.cunningbird.thesis.backend.core.dto.response.OneAppointmentResponse
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

    @GetMapping("/")
    fun getAppointments(@RequestParam executorId: UUID): ResponseEntity<ListAppointmentsResponse> {
        val response = ListAppointmentsResponse()
        service.getAppointmentsForExecutor(executorId).forEach { appointment ->
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
    fun getAppointment(@RequestParam executorId: UUID, @PathVariable appointmentId: UUID): ResponseEntity<OneAppointmentResponse> {
        val appointment = service.getAppointmentForExecutor(executorId, appointmentId)
        val response = OneAppointmentResponse(
            appointment.id,
            appointment.advertId,
            appointment.customerId,
            appointment.executorId,
            appointment.appointmentDateTime,
        )
        return ResponseEntity(response, HttpStatus.OK)
    }
}