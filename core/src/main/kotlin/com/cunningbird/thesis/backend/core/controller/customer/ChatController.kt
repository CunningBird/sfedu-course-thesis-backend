package com.cunningbird.thesis.backend.core.controller.customer

import com.cunningbird.thesis.backend.core.dto.request.chat.SendMessageRequest
import com.cunningbird.thesis.backend.core.dto.response.chat.ListChatsResponse
import com.cunningbird.thesis.backend.core.dto.response.chat.OneChatResponse
import com.cunningbird.thesis.backend.core.service.ChatService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController("CustomerChatController")
@RequestMapping("customer/chats")
class ChatController(
    private val service: ChatService
) {

    @GetMapping
    fun getChatsForCustomer(@RequestParam customerId: UUID): ResponseEntity<ListChatsResponse> {

        val response = ListChatsResponse(UUID.randomUUID())
        return ResponseEntity(response, HttpStatus.OK)
    }

    @GetMapping("{chatId}")
    fun getChatForCustomer(@RequestParam customerId: UUID, @PathVariable chatId: UUID): ResponseEntity<OneChatResponse?> {

        val response = OneChatResponse(UUID.randomUUID())
        return ResponseEntity(response, HttpStatus.OK)
    }

    @PostMapping("{chatId}")
    fun sendMessageForCustomer(@RequestParam customerId: UUID, @PathVariable chatId: UUID, @RequestBody message: SendMessageRequest) {

    }
}