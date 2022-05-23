package com.cunningbird.thesis.backend.core.service

import com.cunningbird.thesis.backend.core.entity.Chat
import com.cunningbird.thesis.backend.core.entity.Message
import com.cunningbird.thesis.backend.core.repository.ChatRepository
import com.cunningbird.thesis.backend.core.repository.MessageRepository
import org.springframework.stereotype.Service
import java.text.SimpleDateFormat
import java.util.*

@Service
class ChatService(
    private val chatRepository: ChatRepository,
    private val messageRepository: MessageRepository
) {

    private val dateFormat = SimpleDateFormat("dd-MM-yyyy hh:mm:ss")

    init {
        val chat1 = Chat(
            UUID.randomUUID(),
            UUID.fromString("bbe0fe62-38d1-11ec-8d3d-0242ac999998"),
            UUID.fromString("bbe0fe62-38d1-11ec-8d3d-0242ac999997"),
        ).apply {
            this.messages = arrayListOf(
                Message(
                    UUID.randomUUID(),
                    UUID.fromString("bbe0fe62-38d1-11ec-8d3d-0242ac999998"),
                    "Flex tex 1",
                    dateFormat.parse("12-03-2019 15:20:32"),
                    this
                ),
                Message(
                    UUID.randomUUID(),
                    UUID.fromString("bbe0fe62-38d1-11ec-8d3d-0242ac999997"),
                    "Flex tex 2",
                    dateFormat.parse("12-03-2019 15:20:32"),
                    this
                ),
                Message(
                    UUID.randomUUID(),
                    UUID.fromString("bbe0fe62-38d1-11ec-8d3d-0242ac999998"),
                    "Flex tex 3",
                    dateFormat.parse("12-03-2019 15:20:32"),
                    this
                ),
                Message(
                    UUID.randomUUID(),
                    UUID.fromString("bbe0fe62-38d1-11ec-8d3d-0242ac999997"),
                    "Flex tex 4",
                    dateFormat.parse("12-03-2019 15:20:32"),
                    this
                ),
                Message(
                    UUID.randomUUID(),
                    UUID.fromString("bbe0fe62-38d1-11ec-8d3d-0242ac999998"),
                    "Flex tex 5",
                    dateFormat.parse("12-03-2019 15:20:32"),
                    this
                ),
                Message(
                    UUID.randomUUID(),
                    UUID.fromString("bbe0fe62-38d1-11ec-8d3d-0242ac999997"),
                    "Flex tex 6",
                    dateFormat.parse("12-03-2019 15:20:32"),
                    this
                ),
                Message(
                    UUID.randomUUID(),
                    UUID.fromString("bbe0fe62-38d1-11ec-8d3d-0242ac999998"),
                    "Flex tex 7",
                    dateFormat.parse("12-03-2019 15:20:32"),
                    this
                ),
                Message(
                    UUID.randomUUID(),
                    UUID.fromString("bbe0fe62-38d1-11ec-8d3d-0242ac999997"),
                    "Flex tex 8",
                    dateFormat.parse("12-03-2019 15:20:32"),
                    this
                ),
                Message(
                    UUID.randomUUID(),
                    UUID.fromString("bbe0fe62-38d1-11ec-8d3d-0242ac999998"),
                    "Flex tex 9",
                    dateFormat.parse("12-03-2019 15:20:32"),
                    this
                ),
                Message(
                    UUID.randomUUID(),
                    UUID.fromString("bbe0fe62-38d1-11ec-8d3d-0242ac999997"),
                    "Flex tex 10",
                    dateFormat.parse("12-03-2019 15:20:32"),
                    this
                )
            )
        }

        chatRepository.save(chat1)
    }

    fun getChatsForCustomer(customerId: UUID): List<Chat> {
        return chatRepository.findAllByCustomerId(customerId)
    }

    fun getChatForCustomer(customerId: UUID, id: UUID): Chat {
        return chatRepository.findByIdAndCustomerId(id, customerId).orElseThrow { Exception("Chat not found") }
    }

    fun sendMessageForCustomer(customerId: UUID, chatId: UUID, text: String, date: Date) {
        val chat = chatRepository.findByIdAndCustomerId(chatId, customerId).orElseThrow { Exception("Chat not found") }
        val message = Message().apply {
            this.authorId = customerId
            this.date = date
            this.text = text
            this.chat = chat
        }
        messageRepository.save(message)
    }

    fun getChatsForExecutor(executorId: UUID): List<Chat> {
        return chatRepository.findAllByExecutorId(executorId)
    }

    fun getChatForExecutor(executorId: UUID, id: UUID): Chat {
        return chatRepository.findByIdAndExecutorId(id, executorId).orElseThrow { Exception("Chat not found") }
    }

    fun sendMessageForExecutor(executorId: UUID, chatId: UUID, text: String, date: Date) {
        val chat = chatRepository.findByIdAndExecutorId(chatId, executorId).orElseThrow { Exception("Chat not found") }
        val message = Message().apply {
            this.authorId = executorId
            this.date = date
            this.text = text
            this.chat = chat
        }
        messageRepository.save(message)
    }
}