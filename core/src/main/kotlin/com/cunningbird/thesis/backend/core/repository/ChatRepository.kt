package com.cunningbird.thesis.backend.core.repository

import com.cunningbird.thesis.backend.core.entity.Chat
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface ChatRepository : JpaRepository<Chat, UUID>