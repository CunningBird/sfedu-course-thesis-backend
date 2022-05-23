package com.cunningbird.thesis.backend.core.dto.response

import java.util.*

data class OneAdvertResponse(
    var id: UUID? = null,
    var title: String? = null,
    var price: Double? = null,
    var description: String? = null,
    var image: String? = null
)
