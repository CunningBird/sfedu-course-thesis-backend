package com.cunningbird.thesis.backend.core.controller.customer

import com.cunningbird.thesis.backend.core.dto.response.OneAdvertResponse
import com.cunningbird.thesis.backend.core.dto.response.ListAdvertsResponse
import com.cunningbird.thesis.backend.core.service.AdvertService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController("CustomerServiceController")
@RequestMapping("customer/adverts")
class AdvertController(
    private val service: AdvertService
) {
    @GetMapping
    fun getAdverts(@RequestParam customerId: UUID): ResponseEntity<ListAdvertsResponse> {
        val response = ListAdvertsResponse()
        service.getAdverts().forEach { advert ->
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
        return ResponseEntity(response, HttpStatus.OK)
    }

    @GetMapping("{advertId}")
    fun getAdverts(@RequestParam customerId: UUID, @PathVariable advertId: UUID): ResponseEntity<OneAdvertResponse> {
        val advert = service.getAdvert(advertId)
        val response = OneAdvertResponse(
            advert.id,
            advert.title,
            advert.price,
            advert.description,
            advert.image
        )
        return ResponseEntity(response, HttpStatus.OK)
    }
}