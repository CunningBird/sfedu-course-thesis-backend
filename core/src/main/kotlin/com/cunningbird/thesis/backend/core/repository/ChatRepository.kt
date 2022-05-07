package com.cunningbird.thesis.backend.core.repository

import com.cunningbird.thesis.backend.core.entity.chat.Chat
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

//interface ChatRepository : JpaRepository<Chat, UUID> {
//}


//    private val dateFormat = SimpleDateFormat("dd-MM-yyyy hh:mm:ss")
//
//    private val repository = arrayListOf(
//        OneChatResponse(
//            UUID.fromString("bbe0fe62-38d1-11ec-8d3d-0242ac130013"),
//            UUID.fromString("bbe0fe62-38d1-11ec-8d3d-0242ac130103"),
//            UUID.fromString("bbe0fe62-38d1-11ec-8d3d-0242ac131003"),
//            "John Doe 1"
//        ).apply {
//            messages = arrayListOf(
//                MessageDto(
//                    UUID.fromString("bbe0fe62-38d1-11ec-8d3d-0242ac130013"),
//                    "Flex tex 1",
//                    dateFormat.parse("12-03-2019 15:20:32"),
//                    MessageAuthor.CUSTOMER
//                ),
//                MessageDto(
//                    UUID.fromString("bbe0fe62-38d1-11ec-8d3d-0242ac130013"),
//                    "Flex tex 2",
//                    dateFormat.parse("12-03-2019 15:20:32"),
//                    MessageAuthor.EXECUTOR
//                ),
//                MessageDto(
//                    UUID.fromString("bbe0fe62-38d1-11ec-8d3d-0242ac130013"),
//                    "Flex tex 3",
//                    dateFormat.parse("12-03-2019 15:20:32"),
//                    MessageAuthor.CUSTOMER
//                ),
//                MessageDto(
//                    UUID.fromString("bbe0fe62-38d1-11ec-8d3d-0242ac130013"),
//                    "Flex tex 4",
//                    dateFormat.parse("12-03-2019 15:20:32"),
//                    MessageAuthor.CUSTOMER
//                ),
//                MessageDto(
//                    UUID.fromString("bbe0fe62-38d1-11ec-8d3d-0242ac130013"),
//                    "Flex tex 5",
//                    dateFormat.parse("12-03-2019 15:20:32"),
//                    MessageAuthor.EXECUTOR
//                ),
//                MessageDto(
//                    UUID.fromString("bbe0fe62-38d1-11ec-8d3d-0242ac130013"),
//                    "Flex tex 6",
//                    dateFormat.parse("12-03-2019 15:20:32"),
//                    MessageAuthor.CUSTOMER
//                ),
//                MessageDto(
//                    UUID.fromString("bbe0fe62-38d1-11ec-8d3d-0242ac130013"),
//                    "Flex tex 7",
//                    dateFormat.parse("12-03-2019 15:20:32"),
//                    MessageAuthor.EXECUTOR
//                ),
//                MessageDto(
//                    UUID.fromString("bbe0fe62-38d1-11ec-8d3d-0242ac130013"),
//                    "Flex tex 8",
//                    dateFormat.parse("12-03-2019 15:20:32"),
//                    MessageAuthor.EXECUTOR
//                ),
//                MessageDto(
//                    UUID.fromString("bbe0fe62-38d1-11ec-8d3d-0242ac130013"),
//                    "Flex tex 9",
//                    dateFormat.parse("12-03-2019 15:20:32"),
//                    MessageAuthor.CUSTOMER
//                ),
//                MessageDto(
//                    UUID.fromString("bbe0fe62-38d1-11ec-8d3d-0242ac130013"),
//                    "Flex tex 10",
//                    dateFormat.parse("12-03-2019 15:20:32"),
//                    MessageAuthor.CUSTOMER
//                ),
//            )
//        },
//        OneChatResponse(
//            UUID.fromString("bbe0fe62-38d1-11ec-8d3d-0242ac130043"),
//            UUID.fromString("bbe0fe62-38d1-11ec-8d3d-0242ac130203"),
//            UUID.fromString("bbe0fe62-38d1-11ec-8d3d-0242ac131003"),
//            "John Doe 4"
//        ).apply {
//            messages = arrayListOf(
//                MessageDto(
//                    UUID.fromString("bbe0fe62-38d1-11ec-8d3d-0242ac130043"),
//                    "Flex tex 1",
//                    dateFormat.parse("12-03-2019 15:20:32"),
//                    MessageAuthor.CUSTOMER
//                ),
//                MessageDto(
//                    UUID.fromString("bbe0fe62-38d1-11ec-8d3d-0242ac130043"),
//                    "Flex tex 2",
//                    dateFormat.parse("12-03-2019 15:20:32"),
//                    MessageAuthor.EXECUTOR
//                ),
//                MessageDto(
//                    UUID.fromString("bbe0fe62-38d1-11ec-8d3d-0242ac130043"),
//                    "Flex tex 3",
//                    dateFormat.parse("12-03-2019 15:20:32"),
//                    MessageAuthor.CUSTOMER
//                ),
//                MessageDto(
//                    UUID.fromString("bbe0fe62-38d1-11ec-8d3d-0242ac130043"),
//                    "Flex tex 4",
//                    dateFormat.parse("12-03-2019 15:20:32"),
//                    MessageAuthor.CUSTOMER
//                ),
//                MessageDto(
//                    UUID.fromString("bbe0fe62-38d1-11ec-8d3d-0242ac130043"),
//                    "Flex tex 5",
//                    dateFormat.parse("12-03-2019 15:20:32"),
//                    MessageAuthor.EXECUTOR
//                ),
//                MessageDto(
//                    UUID.fromString("bbe0fe62-38d1-11ec-8d3d-0242ac130043"),
//                    "Flex tex 6",
//                    dateFormat.parse("12-03-2019 15:20:32"),
//                    MessageAuthor.CUSTOMER
//                ),
//                MessageDto(
//                    UUID.fromString("bbe0fe62-38d1-11ec-8d3d-0242ac130043"),
//                    "Flex tex 7",
//                    dateFormat.parse("12-03-2019 15:20:32"),
//                    MessageAuthor.EXECUTOR
//                ),
//                MessageDto(
//                    UUID.fromString("bbe0fe62-38d1-11ec-8d3d-0242ac130043"),
//                    "Flex tex 8",
//                    dateFormat.parse("12-03-2019 15:20:32"),
//                    MessageAuthor.EXECUTOR
//                ),
//                MessageDto(
//                    UUID.fromString("bbe0fe62-38d1-11ec-8d3d-0242ac130043"),
//                    "Flex tex 9",
//                    dateFormat.parse("12-03-2019 15:20:32"),
//                    MessageAuthor.CUSTOMER
//                ),
//                MessageDto(
//                    UUID.fromString("bbe0fe62-38d1-11ec-8d3d-0242ac130043"),
//                    "Flex tex 10",
//                    dateFormat.parse("12-03-2019 15:20:32"),
//                    MessageAuthor.CUSTOMER
//                ),
//            )
//        },
//    )