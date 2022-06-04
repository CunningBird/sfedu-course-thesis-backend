package com.cunningbird.thesis.backend.core.entity

import java.util.*
import javax.persistence.*

@Entity
data class Message(

    @Id
    @GeneratedValue
    @Column(name = "id", unique = true, nullable = false)
    var id: UUID? = null,

    var authorId: UUID? = null,

    var text: String? = null,
    var date: Date? = null,

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "chat_id", nullable = false)
    var chat: Chat? = null
)
