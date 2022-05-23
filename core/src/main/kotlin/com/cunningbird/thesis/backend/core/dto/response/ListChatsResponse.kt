package com.cunningbird.thesis.backend.core.dto.response

data class ListChatsResponse(
    var list: MutableList<OneChatResponse> = mutableListOf(),
)
