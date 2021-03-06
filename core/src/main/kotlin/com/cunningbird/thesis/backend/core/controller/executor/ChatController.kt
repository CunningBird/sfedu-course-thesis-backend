package com.cunningbird.thesis.backend.core.controller.executor

import com.cunningbird.thesis.backend.core.dto.request.SendMessageRequest
import com.cunningbird.thesis.backend.core.dto.response.ListChatsResponse
import com.cunningbird.thesis.backend.core.dto.response.OneAppointmentResponse
import com.cunningbird.thesis.backend.core.dto.response.OneChatResponse
import com.cunningbird.thesis.backend.core.dto.response.OneMessageResponse
import com.cunningbird.thesis.backend.core.service.ChatService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException
import java.util.*

@RestController("ExecutorChatController")
@RequestMapping("executor/chats")
class ChatController(
    private val service: ChatService
) {
    @GetMapping
    fun getChats(@RequestHeader("executor_id") executorId: UUID): ResponseEntity<ListChatsResponse> {
        try {
            return ResponseEntity(service.getChatsForExecutor(executorId), HttpStatus.OK)
        } catch (e: Exception) {
            throw ResponseStatusException(HttpStatus.BAD_REQUEST, e.message, e)
        }
    }

    @GetMapping("{chatId}")
    fun getChat(@RequestHeader("executor_id") executorId: UUID, @PathVariable chatId: UUID): ResponseEntity<OneChatResponse> {
        try {
            return ResponseEntity(service.getChatForExecutor(executorId, chatId), HttpStatus.OK)
        } catch (e: Exception) {
            throw ResponseStatusException(HttpStatus.BAD_REQUEST, e.message, e)
        }
    }

    @PostMapping("{chatId}")
    fun sendMessage(
        @RequestHeader("executor_id") executorId: UUID,
        @PathVariable chatId: UUID,
        @RequestBody message: SendMessageRequest
    ): ResponseEntity<OneMessageResponse> {
        try {
            return ResponseEntity(service.sendMessageForExecutor(executorId, chatId, message), HttpStatus.CREATED)
        } catch (e: Exception) {
            throw ResponseStatusException(HttpStatus.BAD_REQUEST, e.message, e)
        }
    }

    // TODO implement update method
}