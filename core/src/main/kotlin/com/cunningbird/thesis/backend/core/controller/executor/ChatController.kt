package com.cunningbird.thesis.backend.core.controller.executor

import com.cunningbird.thesis.backend.core.dto.request.SendMessageRequest
import com.cunningbird.thesis.backend.core.dto.response.ListChatsResponse
import com.cunningbird.thesis.backend.core.dto.response.OneChatResponse
import com.cunningbird.thesis.backend.core.dto.response.OneMessageResponse
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
        val response = ListChatsResponse()
        val chatInfo = service.getChatsForExecutor(executorId)
        chatInfo.forEach { chat ->
            val messages = mutableListOf<OneMessageResponse>()
            chat.messages.forEach { message ->
                messages.add(
                    OneMessageResponse(
                        message.id,
                        message.authorId,
                        message.text,
                        message.date
                    )
                )
            }

            response.list.add(
                OneChatResponse(
                    chat.id,
                    chat.executorId,
                    chat.customerId,
                    messages
                )
            )

        }

        return ResponseEntity(response, HttpStatus.OK)
    }

    @GetMapping("{chatId}")
    fun getChat(@RequestParam executorId: UUID, @PathVariable chatId: UUID): ResponseEntity<OneChatResponse> {
        val chat = service.getChatForExecutor(executorId, chatId)

        val messages = mutableListOf<OneMessageResponse>()
        chat.messages.forEach { message ->
            messages.add(
                OneMessageResponse(
                    message.id,
                    message.authorId,
                    message.text,
                    message.date
                )
            )
        }

        val response = OneChatResponse(
            chat.id,
            chat.executorId,
            chat.customerId,
            messages
        )

        return ResponseEntity(response, HttpStatus.OK)
    }

    @PostMapping("{chatId}")
    fun sendMessage(@RequestParam executorId: UUID, @PathVariable chatId: UUID, @RequestBody message: SendMessageRequest) {
        val text = message.text ?: throw Exception("Text is not set")
        val date = message.date ?: throw Exception("Date is not set")
        service.sendMessageForExecutor(executorId, chatId, text, date)
    }

    // TODO implement update method
}