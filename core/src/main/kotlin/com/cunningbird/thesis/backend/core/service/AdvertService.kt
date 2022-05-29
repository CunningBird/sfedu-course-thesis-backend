package com.cunningbird.thesis.backend.core.service

import com.cunningbird.thesis.backend.core.dto.request.CreateAdvertRequest
import com.cunningbird.thesis.backend.core.dto.request.UpdateAdvertRequest
import com.cunningbird.thesis.backend.core.dto.response.ListAdvertsResponse
import com.cunningbird.thesis.backend.core.dto.response.OneAdvertResponse
import com.cunningbird.thesis.backend.core.entity.Advert
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
                mapAdvertResponseFromEntity(advert)
            )
        }
        return response
    }

    fun getAdvertForCustomer(id: UUID): OneAdvertResponse {
        val advert = repository.findById(id).orElseThrow { Exception("Advert not found") }
        return mapAdvertResponseFromEntity(advert)
    }

    fun getAdvertsByExecutor(executorId: UUID): ListAdvertsResponse {
        val response = ListAdvertsResponse()
        repository.findAllByExecutorId(executorId).forEach { advert ->
            response.list.add(
                mapAdvertResponseFromEntity(advert)
            )
        }

        return response
    }

    fun getAdvertByExecutor(executorId: UUID, id: UUID): OneAdvertResponse {
        val advert = repository.findByIdAndExecutorId(id, executorId).orElseThrow { Exception("Advert not found") }
        return mapAdvertResponseFromEntity(advert)
    }

    fun createAdvertForExecutor(executorId: UUID, request: CreateAdvertRequest): OneAdvertResponse {
        val advert = Advert().apply {
            this.title = request.title
            this.price = request.price
            this.address = request.address
            this.description = request.description
            this.image = request.image
        }
        repository.save(advert)
        return mapAdvertResponseFromEntity(advert)
    }

    fun updateAdvertForExecutor(executorId: UUID, id: UUID, request: UpdateAdvertRequest): OneAdvertResponse {
        val advert = repository.findByIdAndExecutorId(id, executorId).orElseThrow { Exception("Advert not found") }
        advert.apply {
            this.title = request.title ?: this.title
            this.price = request.price ?: this.price
            this.address = request.address ?: this.address
            this.description = request.description ?: this.description
            this.image = request.image ?: this.image
        }
        repository.save(advert)
        return mapAdvertResponseFromEntity(advert)
    }

    private fun mapAdvertResponseFromEntity(entity: Advert): OneAdvertResponse {
        return OneAdvertResponse(
            entity.id,
            entity.title,
            entity.price,
            entity.description,
            entity.image
        )
    }
}