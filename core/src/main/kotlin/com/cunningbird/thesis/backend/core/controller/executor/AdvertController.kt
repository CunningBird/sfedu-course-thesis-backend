package com.cunningbird.thesis.backend.core.controller.executor

import com.cunningbird.thesis.backend.core.dto.response.ListAdvertsResponse
import com.cunningbird.thesis.backend.core.dto.response.OneAdvertResponse
import com.cunningbird.thesis.backend.core.service.AdvertService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException
import java.util.*

@RestController("ExecutorServiceController")
@RequestMapping("executor/adverts")
class AdvertController(
    private val service: AdvertService
) {
    @GetMapping
    fun getAdverts(@RequestParam executorId: UUID): ResponseEntity<ListAdvertsResponse> {
        try {
            return ResponseEntity(service.getAdvertsByExecutor(executorId), HttpStatus.OK)
        } catch (e: Exception) {
            throw ResponseStatusException(HttpStatus.BAD_REQUEST, e.message, e)
        }
    }

    @GetMapping("{advertId}")
    fun getAdvert(@RequestParam executorId: UUID, @PathVariable advertId: UUID): ResponseEntity<OneAdvertResponse> {
        try {
            return ResponseEntity(service.getAdvertByExecutor(executorId, advertId), HttpStatus.OK)
        } catch (e: Exception) {
            throw ResponseStatusException(HttpStatus.BAD_REQUEST, e.message, e)
        }
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