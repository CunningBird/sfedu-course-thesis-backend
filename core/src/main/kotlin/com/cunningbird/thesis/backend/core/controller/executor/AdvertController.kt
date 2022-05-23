package com.cunningbird.thesis.backend.core.controller.executor

import com.cunningbird.thesis.backend.core.dto.response.ListAdvertsResponse
import com.cunningbird.thesis.backend.core.dto.response.OneAdvertResponse
import com.cunningbird.thesis.backend.core.service.AdvertService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController("ExecutorServiceController")
@RequestMapping("executor/adverts")
class AdvertController(
    private val service: AdvertService
) {
    @GetMapping
    fun getAdverts(@RequestParam executorId: UUID): ResponseEntity<ListAdvertsResponse> {
        val response = ListAdvertsResponse()
        service.getAdvertsByExecutor(executorId).forEach { advert ->
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
    fun getAdvert(@RequestParam executorId: UUID, @PathVariable advertId: UUID): ResponseEntity<OneAdvertResponse> {
        val advert = service.getAdvertByExecutor(executorId, advertId)
        val response = OneAdvertResponse(
            advert.id,
            advert.title,
            advert.price,
            advert.description,
            advert.image
        )
        return ResponseEntity(response, HttpStatus.OK)
    }

//    TODO implement this
//
//    @PostMapping
//    fun createAdvert(@RequestParam executorId: UUID, @RequestBody request: CreateAdvertRequest) {
//        service.createAdvert()
//    }
//
//    @PatchMapping("{advertId}")
//    fun updateAdvert(@RequestParam executorId: UUID, @PathVariable advertId: UUID, @RequestBody request: UpdateAdvertRequest) {
//        service.updateAdvert()
//    }
}