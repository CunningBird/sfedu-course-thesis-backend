package com.cunningbird.thesis.backend.core.dto.response

import java.util.*

data class OneMessageResponse(
    var id: UUID? = null,

    var authorId: UUID? = null,

    val text: String? = null,
    val date: Date? = null
)
