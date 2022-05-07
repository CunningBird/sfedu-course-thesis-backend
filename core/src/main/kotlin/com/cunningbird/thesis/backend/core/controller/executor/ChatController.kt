package com.cunningbird.thesis.backend.core.controller.executor

import com.cunningbird.thesis.backend.core.dto.request.chat.SendMessageRequest
import com.cunningbird.thesis.backend.core.dto.response.chat.ListChatsResponse
import com.cunningbird.thesis.backend.core.dto.response.chat.OneChatResponse
import com.cunningbird.thesis.backend.core.service.ChatService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController("ExecutorChatController")
@RequestMapping("executor/chats")
class ChatController(
    private val service: ChatService
) {

    @GetMapping
    fun getChats(@RequestParam executorId: UUID): ResponseEntity<ListChatsResponse> {

        val response = ListChatsResponse(UUID.randomUUID())
        return ResponseEntity(response, HttpStatus.OK)
    }

    @GetMapping("{chatId}")
    fun getChat(@RequestParam executorId: UUID, @PathVariable chatId: UUID): ResponseEntity<OneChatResponse?> {

        val response = OneChatResponse(UUID.randomUUID())
        return ResponseEntity(response, HttpStatus.OK)
    }

    @PostMapping("{chatId}")
    fun sendMessage(@RequestParam executorId: UUID, @PathVariable chatId: UUID, @RequestBody message: SendMessageRequest) {

    }
}