package com.cunningbird.thesis.backend.core.controller.customer

import com.cunningbird.thesis.backend.core.dto.request.SendMessageRequest
import com.cunningbird.thesis.backend.core.dto.response.*
import com.cunningbird.thesis.backend.core.service.ChatService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException
import java.util.*

@RestController("CustomerChatController")
@RequestMapping("customer/chats")
class ChatController(
    private val service: ChatService
) {
    @GetMapping
    fun getChats(@RequestHeader("customer_id") customerId: UUID): ResponseEntity<ListChatsResponse> {
        try {
            return ResponseEntity(service.getChatsForCustomer(customerId), HttpStatus.OK)
        } catch (e: Exception) {
            throw ResponseStatusException(HttpStatus.BAD_REQUEST, e.message, e)
        }
    }

    @GetMapping("{chatId}")
    fun getChat(@RequestHeader("customer_id") customerId: UUID, @PathVariable chatId: UUID): ResponseEntity<OneChatResponse> {
        try {
            return ResponseEntity(service.getChatForCustomer(customerId, chatId), HttpStatus.OK)
        } catch (e: Exception) {
            throw ResponseStatusException(HttpStatus.BAD_REQUEST, e.message, e)
        }
    }

    @PostMapping("{chatId}")
    fun sendMessage(
        @RequestHeader("customer_id") customerId: UUID,
        @PathVariable chatId: UUID,
        @RequestBody message: SendMessageRequest
    ) {
        try {
            service.sendMessageForCustomer(customerId, chatId, message)
        } catch (e: Exception) {
            throw ResponseStatusException(HttpStatus.BAD_REQUEST, e.message, e)
        }
    }

    // TODO implement update method
}