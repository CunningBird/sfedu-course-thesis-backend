package com.cunningbird.thesis.backend.core.repository

import com.cunningbird.thesis.backend.core.entity.Appointment
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface AppointmentRepository : JpaRepository<Appointment, UUID> {
    fun findAllByCustomerId(customerId: UUID): List<Appointment>

    fun findByIdAndCustomerId(id: UUID, customerId: UUID): Optional<Appointment>

    fun findAllByExecutorId(executorId: UUID): List<Appointment>

    fun findByIdAndExecutorId(id: UUID, executorId: UUID): Optional<Appointment>
}