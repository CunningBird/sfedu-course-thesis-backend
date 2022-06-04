package com.cunningbird.thesis.backend.core.dto.request

import java.util.*

data class SendMessageRequest(
    val text: String? = null,
    val date: Date? = null,
)
