package com.cunningbird.thesis.backend.core.dto.request

data class CreateAdvertRequest(
    var title: String? = null,
    var price: Double? = null,
    var address: String? = null,
    var description: String? = null,
    var image: String? = null,
)