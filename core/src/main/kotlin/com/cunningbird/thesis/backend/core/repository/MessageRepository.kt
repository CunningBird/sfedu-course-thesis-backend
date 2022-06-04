package com.cunningbird.thesis.backend.core.repository

import com.cunningbird.thesis.backend.core.entity.Message
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface MessageRepository : JpaRepository<Message, UUID>