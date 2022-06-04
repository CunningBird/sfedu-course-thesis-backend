package com.cunningbird.thesis.backend.core.service

import com.cunningbird.thesis.backend.core.dto.request.CreateAppointmentRequest
import com.cunningbird.thesis.backend.core.dto.response.ListAppointmentsResponse
import com.cunningbird.thesis.backend.core.dto.response.OneAppointmentResponse
import com.cunningbird.thesis.backend.core.entity.Advert
import com.cunningbird.thesis.backend.core.entity.Appointment
import com.cunningbird.thesis.backend.core.repository.AdvertRepository
import com.cunningbird.thesis.backend.core.repository.AppointmentRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
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
            UUID.fromString("bbe0fe62-38d1-11ec-8d3d-0242ac999997"),
            UUID.fromString("bbe0fe62-38d1-11ec-8d3d-0242ac999998"),
            dateFormat.parse("01-06-2022 10:30"),
            Advert(
                UUID.randomUUID(),
                UUID.fromString("bbe0fe62-38d1-11ec-8d3d-0242ac999998"),
                "Awesome Advert 1",
                222.33,
                "Flex address 1",
                "Just awesome",
                "https://via.placeholder.com/1200x900"
            )
        ),
        Appointment(
            UUID.randomUUID(),
            UUID.fromString("bbe0fe62-38d1-11ec-8d3d-0242ac999997"),
            UUID.fromString("bbe0fe62-38d1-11ec-8d3d-0242ac999998"),
            dateFormat.parse("01-06-2022 11:00"),
            Advert(
                UUID.randomUUID(),
                UUID.fromString("bbe0fe62-38d1-11ec-8d3d-0242ac999998"),
                "Awesome Advert 2",
                322.33,
                "Flex address 2",
                "Just awesome",
                "https://via.placeholder.com/1200x900"
            )
        ),
        Appointment(
            UUID.randomUUID(),
            UUID.fromString("bbe0fe62-38d1-11ec-8d3d-0242ac999997"),
            UUID.fromString("bbe0fe62-38d1-11ec-8d3d-0242ac999998"),
            dateFormat.parse("01-06-2022 11:30"),
            Advert(
                UUID.randomUUID(),
                UUID.fromString("bbe0fe62-38d1-11ec-8d3d-0242ac999998"),
                "Awesome Advert 3",
                422.33,
                "Flex address 3",
                "Just awesome",
                "https://via.placeholder.com/1200x900"
            )
        ),
        Appointment(
            UUID.randomUUID(),
            UUID.fromString("bbe0fe62-38d1-11ec-8d3d-0242ac999997"),
            UUID.fromString("bbe0fe62-38d1-11ec-8d3d-0242ac999998"),
            dateFormat.parse("01-06-2022 12:00"),
            Advert(
                UUID.randomUUID(),
                UUID.fromString("bbe0fe62-38d1-11ec-8d3d-0242ac999998"),
                "Awesome Advert 4",
                522.33,
                "Flex address 4",
                "Just awesome",
                "https://via.placeholder.com/1200x900"
            )
        ),
        Appointment(
            UUID.randomUUID(),
            UUID.fromString("bbe0fe62-38d1-11ec-8d3d-0242ac999997"),
            UUID.fromString("bbe0fe62-38d1-11ec-8d3d-0242ac999998"),
            dateFormat.parse("01-06-2022 12:30"),
            Advert(
                UUID.randomUUID(),
                UUID.fromString("bbe0fe62-38d1-11ec-8d3d-0242ac999998"),
                "Awesome Advert 5",
                622.33,
                "Flex address 5",
                "Just awesome",
                "https://via.placeholder.com/1200x900"
            )
        ),
        Appointment(
            UUID.randomUUID(),
            UUID.fromString("bbe0fe62-38d1-11ec-8d3d-0242ac999997"),
            UUID.fromString("bbe0fe62-38d1-11ec-8d3d-0242ac999998"),
            dateFormat.parse("01-06-2022 13:00"),
            Advert(
                UUID.randomUUID(),
                UUID.fromString("bbe0fe62-38d1-11ec-8d3d-0242ac999998"),
                "Awesome Advert 6",
                722.33,
                "Flex address 6",
                "Just awesome",
                "https://via.placeholder.com/1200x900"
            )
        )
    )

    init {
        testData.forEach { appointmentRepository.save(it) }
    }

    fun getAppointmentsForCustomer(customerId: UUID): ListAppointmentsResponse {
        val response = ListAppointmentsResponse()
        appointmentRepository.findAllByCustomerId(customerId).forEach { appointment ->
            response.list.add(
                mapAppointmentResponseFromEntity(appointment)
            )
        }
        return response
    }

    fun getAppointmentForCustomer(customerId: UUID, id: UUID): OneAppointmentResponse {
        val appointment = appointmentRepository.findByIdAndCustomerId(id, customerId)
            .orElseThrow { Exception("Appointment not found") }
        return mapAppointmentResponseFromEntity(appointment)
    }

    fun getAppointmentsForExecutor(executorId: UUID): ListAppointmentsResponse {
        val response = ListAppointmentsResponse()
        appointmentRepository.findAllByExecutorId(executorId).forEach { appointment ->
            response.list.add(
                mapAppointmentResponseFromEntity(appointment)
            )
        }
        return response
    }

    fun getAppointmentForExecutor(executorId: UUID, id: UUID): OneAppointmentResponse {
        val appointment = appointmentRepository.findByIdAndExecutorId(id, executorId)
            .orElseThrow { Exception("Appointment not found") }
        return mapAppointmentResponseFromEntity(appointment)
    }

    @Transactional
    fun createAppointment(customerId: UUID, advertId: UUID, request: CreateAppointmentRequest): OneAppointmentResponse {
        val date = request.date ?: throw Exception("Date is not set")
        val advert = advertRepository.findById(advertId).orElseThrow { Exception("Advert not found") }
        val appointment = Appointment().apply {
            this.customerId = customerId
            this.executorId = advert.executorId
            this.date = date
            this.advert = advert
        }
        appointmentRepository.save(appointment)
        return mapAppointmentResponseFromEntity(appointment)
    }

    private fun mapAppointmentResponseFromEntity(entity: Appointment): OneAppointmentResponse {
        return OneAppointmentResponse(
            entity.id,
            entity.advert?.title,
            entity.advert?.image,
            entity.date
        )
    }
}