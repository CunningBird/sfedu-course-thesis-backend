package com.cunningbird.thesis.backend.core.dto.response

import java.util.*

data class OneChatResponse(
    var id: UUID? = null,

    var customerId: UUID? = null,
    var executorId: UUID? = null,

    val customerAvatar: String? = null,
    val executorAvatar: String? = null,
    val customerName: String? = null,
    val executorName: String? = null,

    var messages: MutableList<OneMessageResponse> = mutableListOf()
)
