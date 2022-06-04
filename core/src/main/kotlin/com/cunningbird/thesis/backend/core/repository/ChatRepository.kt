package com.cunningbird.thesis.backend.core.repository

import com.cunningbird.thesis.backend.core.entity.Appointment
import com.cunningbird.thesis.backend.core.entity.Chat
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface ChatRepository : JpaRepository<Chat, UUID> {

    fun findAllByCustomerId(customerId: UUID): List<Chat>

    fun findByIdAndCustomerId(id: UUID, customerId: UUID): Optional<Chat>

    fun findAllByExecutorId(executorId: UUID): List<Chat>

    fun findByIdAndExecutorId(id: UUID, executorId: UUID): Optional<Chat>
}