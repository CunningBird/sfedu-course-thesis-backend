package com.cunningbird.thesis.backend.core.entity

import java.util.*
import javax.persistence.*

@Entity
data class Chat(

    @Id
    @GeneratedValue
    @Column(name = "id", unique = true, nullable = false)
    var id: UUID? = null,

    var customerId: UUID? = null,
    var executorId: UUID? = null,
    val customerAvatar: String? = null,
    val executorAvatar: String? = null,
    val customerName: String? = null,
    val executorName: String? = null,

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "chat", cascade = [CascadeType.ALL])
    var messages: MutableList<Message> = mutableListOf()
)
