package com.cunningbird.thesis.backend.core.entity.chat

import java.util.*
import javax.persistence.Column
import javax.persistence.GeneratedValue
import javax.persistence.Id

data class Chat(

    @Id
    @GeneratedValue
    @Column(name = "id", unique = true, nullable = false)
    private var id: UUID? = null,

    private var userId: UUID? = null,
    private var executorId: UUID? = null,

    private val messages: List<Message> = listOf()
)
