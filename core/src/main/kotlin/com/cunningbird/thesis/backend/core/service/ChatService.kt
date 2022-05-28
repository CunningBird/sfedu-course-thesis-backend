package com.cunningbird.thesis.backend.core.service

import com.cunningbird.thesis.backend.core.dto.request.SendMessageRequest
import com.cunningbird.thesis.backend.core.dto.response.ListChatsResponse
import com.cunningbird.thesis.backend.core.dto.response.OneChatResponse
import com.cunningbird.thesis.backend.core.dto.response.OneMessageResponse
import com.cunningbird.thesis.backend.core.entity.Chat
import com.cunningbird.thesis.backend.core.entity.Message
import com.cunningbird.thesis.backend.core.repository.ChatRepository
import com.cunningbird.thesis.backend.core.repository.MessageRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
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
            UUID.fromString("bbe0fe62-38d1-11ec-8d3d-0242ac999997"),
            UUID.fromString("bbe0fe62-38d1-11ec-8d3d-0242ac999998"),
            "https://sun9-40.userapi.com/impg/okrr7lk-uTHQ6Hd7oxroSGAizxD7_vdMvUqIxg/vJnAl-FEDG0.jpg?size=1620x2160&quality=95&sign=f99f69daaee0315ace8912dd5377990a&type=album",
            "https://sun9-40.userapi.com/impg/okrr7lk-uTHQ6Hd7oxroSGAizxD7_vdMvUqIxg/vJnAl-FEDG0.jpg?size=1620x2160&quality=95&sign=f99f69daaee0315ace8912dd5377990a&type=album",
            "Customer Name",
            "Executor Name"
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

    fun getChatsForCustomer(customerId: UUID): ListChatsResponse {
        val response = ListChatsResponse()
        val chatInfo = chatRepository.findAllByCustomerId(customerId)
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
                    chat.customerAvatar,
                    chat.executorAvatar,
                    chat.customerName,
                    chat.executorName,
                    messages
                )
            )

        }
        return response
    }

    fun getChatForCustomer(customerId: UUID, id: UUID): OneChatResponse {

        val chat = chatRepository.findByIdAndCustomerId(id, customerId).orElseThrow { Exception("Chat not found") }

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
            chat.customerAvatar,
            chat.executorAvatar,
            chat.customerName,
            chat.executorName,
            messages
        )

        return response
    }

    @Transactional
    fun sendMessageForCustomer(customerId: UUID, chatId: UUID, message: SendMessageRequest): OneMessageResponse {
        val text = message.text ?: throw Exception("Text is not set")
        val date = message.date ?: throw Exception("Date is not set")
        val chat = chatRepository.findByIdAndCustomerId(chatId, customerId).orElseThrow { Exception("Chat not found") }

        val entity = Message().apply {
            this.authorId = customerId
            this.date = date
            this.text = text
            this.chat = chat
        }
        messageRepository.save(entity)

        return OneMessageResponse(
            entity.id,
            entity.authorId,
            entity.text,
            entity.date
        )
    }

    fun getChatsForExecutor(executorId: UUID): ListChatsResponse {
        val response = ListChatsResponse()
        val chatInfo = chatRepository.findAllByExecutorId(executorId)
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
                    chat.customerAvatar,
                    chat.executorAvatar,
                    chat.customerName,
                    chat.executorName,
                    messages
                )
            )
        }
        return response
    }

    fun getChatForExecutor(executorId: UUID, id: UUID): OneChatResponse {
        val chat = chatRepository.findByIdAndExecutorId(id, executorId).orElseThrow { Exception("Chat not found") }

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
            chat.customerAvatar,
            chat.executorAvatar,
            chat.customerName,
            chat.executorName,
            messages
        )
        return response
    }

    @Transactional
    fun sendMessageForExecutor(executorId: UUID, chatId: UUID, message: SendMessageRequest): OneMessageResponse {
        val text = message.text ?: throw Exception("Text is not set")
        val date = message.date ?: throw Exception("Date is not set")
        val chat = chatRepository.findByIdAndExecutorId(chatId, executorId).orElseThrow { Exception("Chat not found") }

        val entity = Message().apply {
            this.authorId = executorId
            this.date = date
            this.text = text
            this.chat = chat
        }
        messageRepository.save(entity)

        return OneMessageResponse(
            entity.id,
            entity.authorId,
            entity.text,
            entity.date
        )
    }
}