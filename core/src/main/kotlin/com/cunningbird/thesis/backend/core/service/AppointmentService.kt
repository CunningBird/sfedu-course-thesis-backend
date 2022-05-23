package com.cunningbird.thesis.backend.core.service

import com.cunningbird.thesis.backend.core.dto.response.OneAppointmentResponse
import com.cunningbird.thesis.backend.core.entity.Appointment
import com.cunningbird.thesis.backend.core.repository.AdvertRepository
import com.cunningbird.thesis.backend.core.repository.AppointmentRepository
import org.springframework.stereotype.Service
import java.text.SimpleDateFormat
import java.util.*

@Service
class AppointmentService(
    private val appointmentRepository: AppointmentRepository,
    private val advertRepository: AdvertRepository
) {

    private val dateFormat = SimpleDateFormat("dd-MM-yyyy hh:mm")

    private val testData = listOf(
        Appointment(
            UUID.randomUUID(),
            UUID.fromString("bbe0fe62-38d1-11ec-8d3d-0242ac888888"),
            UUID.fromString("bbe0fe62-38d1-11ec-8d3d-0242ac999998"),
            UUID.fromString("bbe0fe62-38d1-11ec-8d3d-0242ac999997"),
            dateFormat.parse("26-01-2022 10:30"),
        ),
        Appointment(
            UUID.randomUUID(),
            UUID.fromString("bbe0fe62-38d1-11ec-8d3d-0242ac888887"),
            UUID.fromString("bbe0fe62-38d1-11ec-8d3d-0242ac999998"),
            UUID.fromString("bbe0fe62-38d1-11ec-8d3d-0242ac999997"),
            dateFormat.parse("26-01-2022 10:30"),
        ),
        Appointment(
            UUID.randomUUID(),
            UUID.fromString("bbe0fe62-38d1-11ec-8d3d-0242ac888886"),
            UUID.fromString("bbe0fe62-38d1-11ec-8d3d-0242ac999998"),
            UUID.fromString("bbe0fe62-38d1-11ec-8d3d-0242ac999997"),
            dateFormat.parse("26-01-2022 10:30"),
        ),
        Appointment(
            UUID.randomUUID(),
            UUID.fromString("bbe0fe62-38d1-11ec-8d3d-0242ac888885"),
            UUID.fromString("bbe0fe62-38d1-11ec-8d3d-0242ac999998"),
            UUID.fromString("bbe0fe62-38d1-11ec-8d3d-0242ac999997"),
            dateFormat.parse("26-01-2022 10:30"),
        ),
        Appointment(
            UUID.randomUUID(),
            UUID.fromString("bbe0fe62-38d1-11ec-8d3d-0242ac888884"),
            UUID.fromString("bbe0fe62-38d1-11ec-8d3d-0242ac999998"),
            UUID.fromString("bbe0fe62-38d1-11ec-8d3d-0242ac999997"),
            dateFormat.parse("26-01-2022 10:30"),
        ),
        Appointment(
            UUID.randomUUID(),
            UUID.fromString("bbe0fe62-38d1-11ec-8d3d-0242ac888883"),
            UUID.fromString("bbe0fe62-38d1-11ec-8d3d-0242ac999998"),
            UUID.fromString("bbe0fe62-38d1-11ec-8d3d-0242ac999997"),
            dateFormat.parse("26-01-2022 10:30"),
        )
    )

    init {
        testData.forEach { appointmentRepository.save(it) }
    }

    fun getAppointmentsForCustomer(customerId: UUID): List<Appointment> {
        return appointmentRepository.findAllByCustomerId(customerId)
    }

    fun getAppointmentForCustomer(customerId: UUID, id: UUID): Appointment {
        return appointmentRepository.findByIdAndCustomerId(id, customerId)
            .orElseThrow { Exception("Appointment not found") }
    }

    fun getAppointmentsForExecutor(executorId: UUID): List<Appointment> {
        return appointmentRepository.findAllByExecutorId(executorId)
    }

    fun getAppointmentForExecutor(executorId: UUID, id: UUID): Appointment {
        return appointmentRepository.findByIdAndExecutorId(id, executorId)
            .orElseThrow { Exception("Appointment not found") }
    }

    fun createAppointment(customerId: UUID, advertId: UUID, date: Date) {
        val advert = advertRepository.findById(advertId).orElseThrow { Exception("Advert not found") }
        val appointment = Appointment().apply {
            this.advertId = advert.id
            this.customerId = customerId
            this.executorId = advert.executorId
            this.appointmentDateTime = date
        }
        appointmentRepository.save(appointment)
    }
}