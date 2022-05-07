package com.cunningbird.thesis.backend.core.dto.response.service

import java.util.*

data class OneServiceResponse(
    var id: UUID? = null,
    var title: String? = null,
    var price: Double? = null,
    var description: String? = null,
    var image: String? = null
)
