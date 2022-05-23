package com.cunningbird.thesis.backend.core.service

import com.cunningbird.thesis.backend.core.entity.Advert
import com.cunningbird.thesis.backend.core.repository.AdvertRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class AdvertService(
    private val repository: AdvertRepository
) {

    private val testData = listOf(
        Advert(
            UUID.fromString("bbe0fe62-38d1-11ec-8d3d-0242ac888888"),
            UUID.fromString("bbe0fe62-38d1-11ec-8d3d-0242ac999997"),
            "Awesome Advert 1",
            222.33,
            "Flex address 1",
            "https://via.placeholder.com/1200x900"
        ),
        Advert(
            UUID.fromString("bbe0fe62-38d1-11ec-8d3d-0242ac888887"),
            UUID.fromString("bbe0fe62-38d1-11ec-8d3d-0242ac999997"),
            "Awesome Advert 2",
            322.33,
            "Flex address 2",
            "https://via.placeholder.com/1200x900"
        ),
        Advert(
            UUID.fromString("bbe0fe62-38d1-11ec-8d3d-0242ac888886"),
            UUID.fromString("bbe0fe62-38d1-11ec-8d3d-0242ac999997"),
            "Awesome Advert 3",
            422.33,
            "Flex address 3",
            "https://via.placeholder.com/1200x900"
        ),
        Advert(
            UUID.fromString("bbe0fe62-38d1-11ec-8d3d-0242ac888885"),
            UUID.fromString("bbe0fe62-38d1-11ec-8d3d-0242ac999997"),
            "Awesome Advert 4",
            522.33,
            "Flex address 4",
            "https://via.placeholder.com/1200x900"
        ),
        Advert(
            UUID.fromString("bbe0fe62-38d1-11ec-8d3d-0242ac888884"),
            UUID.fromString("bbe0fe62-38d1-11ec-8d3d-0242ac999997"),
            "Awesome Advert 5",
            622.33,
            "Flex address 5",
            "https://via.placeholder.com/1200x900"
        ),
        Advert(
            UUID.fromString("bbe0fe62-38d1-11ec-8d3d-0242ac888883"),
            UUID.fromString("bbe0fe62-38d1-11ec-8d3d-0242ac999997"),
            "Awesome Advert 6",
            722.33,
            "Flex address 6",
            "https://via.placeholder.com/1200x900"
        )
    )

    init {
        testData.forEach { repository.save(it) }
    }

    fun getAdverts(): List<Advert> {
        return repository.findAll()
    }

    fun getAdvert(id: UUID): Advert {
        return repository.findById(id).orElseThrow { Exception("Advert not found") }
    }

    fun getAdvertsByExecutor(executorId: UUID): List<Advert> {
        return repository.findAllByExecutorId(executorId)
    }

    fun getAdvertByExecutor(executorId: UUID, id: UUID): Advert {
        return repository.findByIdAndExecutorId(id, executorId).orElseThrow { Exception("Advert not found") }
    }

//    TODO implement this
//
//    fun createAdvert() {
//        val advert
//        return repository.save()
//    }
//
//    fun updateAdvert() {
//        val advert
//        return repository.save()
//    }
}