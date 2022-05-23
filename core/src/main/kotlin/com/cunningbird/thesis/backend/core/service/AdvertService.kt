package com.cunningbird.thesis.backend.core.service

import com.cunningbird.thesis.backend.core.dto.response.ListAdvertsResponse
import com.cunningbird.thesis.backend.core.dto.response.OneAdvertResponse
import com.cunningbird.thesis.backend.core.repository.AdvertRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class AdvertService(
    private val repository: AdvertRepository
) {

    fun getAdvertsForCustomer(): ListAdvertsResponse {
        val response = ListAdvertsResponse()
        repository.findAll().forEach { advert ->
            response.list.add(
                OneAdvertResponse(
                    advert.id,
                    advert.title,
                    advert.price,
                    advert.description,
                    advert.image
                )
            )
        }
        return response
    }

    fun getAdvertForCustomer(id: UUID): OneAdvertResponse {
        val advert = repository.findById(id).orElseThrow { Exception("Advert not found") }
        return OneAdvertResponse(
            advert.id,
            advert.title,
            advert.price,
            advert.description,
            advert.image
        )
    }

    fun getAdvertsByExecutor(executorId: UUID): ListAdvertsResponse {
        val response = ListAdvertsResponse()
        repository.findAllByExecutorId(executorId).forEach { advert ->
            response.list.add(
                OneAdvertResponse(
                    advert.id,
                    advert.title,
                    advert.price,
                    advert.description,
                    advert.image
                )
            )
        }

        return response
    }

    fun getAdvertByExecutor(executorId: UUID, id: UUID): OneAdvertResponse {
        val advert = repository.findByIdAndExecutorId(id, executorId).orElseThrow { Exception("Advert not found") }
        return OneAdvertResponse(
            advert.id,
            advert.title,
            advert.price,
            advert.description,
            advert.image
        )
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