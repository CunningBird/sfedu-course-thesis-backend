package com.cunningbird.thesis.backend.core.dto.request

import java.util.*

data class UpdateAdvertRequest(
    var title: String? = null,
    var price: Double? = null,
    var address: String? = null,
    var description: String? = null,
    var image: String? = null,
)