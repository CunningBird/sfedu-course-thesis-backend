package com.cunningbird.thesis.backend.core.dto.response

data class ListAdvertsResponse(
    var list: MutableList<OneAdvertResponse> = mutableListOf()
)