package com.cunningbird.thesis.backend.core.dto.response

import java.util.*

data class OneChatResponse(
    var id: UUID? = null,

    var customerId: UUID? = null,
    var executorId: UUID? = null,

    var messages: MutableList<OneMessageResponse> = mutableListOf()
)
