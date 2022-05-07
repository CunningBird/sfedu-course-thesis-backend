package com.cunningbird.thesis.backend.core.entity.chat

import java.util.*
import javax.persistence.Column
import javax.persistence.GeneratedValue
import javax.persistence.Id

data class Message(

    @Id
    @GeneratedValue
    @Column(name = "id", unique = true, nullable = false)
    private var id: UUID? = null,

    private var chatId: UUID? = null,
    private var authorId: UUID? = null,

    private val text: String? = null,
    private val sentDateTime: Date? = null
)
