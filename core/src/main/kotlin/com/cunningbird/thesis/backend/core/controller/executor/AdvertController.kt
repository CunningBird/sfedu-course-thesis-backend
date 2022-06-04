package com.cunningbird.thesis.backend.core.controller.executor

import com.cunningbird.thesis.backend.core.dto.request.CreateAdvertRequest
import com.cunningbird.thesis.backend.core.dto.request.UpdateAdvertRequest
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
    fun getAdverts(@RequestHeader("executor_id") executorId: UUID): ResponseEntity<ListAdvertsResponse> {
        try {
            return ResponseEntity(service.getAdvertsByExecutor(executorId), HttpStatus.OK)
        } catch (e: Exception) {
            throw ResponseStatusException(HttpStatus.BAD_REQUEST, e.message, e)
        }
    }

    @GetMapping("{advertId}")
    fun getAdvert(@RequestHeader("executor_id") executorId: UUID, @PathVariable advertId: UUID): ResponseEntity<OneAdvertResponse> {
        try {
            return ResponseEntity(service.getAdvertByExecutor(executorId, advertId), HttpStatus.OK)
        } catch (e: Exception) {
            throw ResponseStatusException(HttpStatus.BAD_REQUEST, e.message, e)
        }
    }

    @PostMapping
    fun createAdvert(@RequestHeader("executor_id") executorId: UUID, @RequestBody request: CreateAdvertRequest): ResponseEntity<OneAdvertResponse> {
        try {
            return ResponseEntity(service.createAdvertForExecutor(executorId, request), HttpStatus.OK)
        } catch (e: Exception) {
            throw ResponseStatusException(HttpStatus.BAD_REQUEST, e.message, e)
        }
    }

    @PatchMapping("{advertId}")
    fun updateAdvert(@RequestHeader("executor_id") executorId: UUID, @PathVariable advertId: UUID, @RequestBody request: UpdateAdvertRequest): ResponseEntity<OneAdvertResponse> {
        try {
            return ResponseEntity(service.updateAdvertForExecutor(executorId, advertId, request), HttpStatus.OK)
        } catch (e: Exception) {
            throw ResponseStatusException(HttpStatus.BAD_REQUEST, e.message, e)
        }
    }
}