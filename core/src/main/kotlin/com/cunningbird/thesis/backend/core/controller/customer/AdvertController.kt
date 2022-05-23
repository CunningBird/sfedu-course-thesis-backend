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
import org.springframework.web.server.ResponseStatusException
import java.util.*

@RestController("CustomerServiceController")
@RequestMapping("customer/adverts")
class AdvertController(
    private val service: AdvertService
) {
    @GetMapping
    fun getAdverts(@RequestParam customerId: UUID): ResponseEntity<ListAdvertsResponse> {
        try {
            return ResponseEntity(service.getAdvertsForCustomer(), HttpStatus.OK)
        } catch (e: Exception) {
            throw ResponseStatusException(HttpStatus.BAD_REQUEST, e.message, e)
        }
    }

    @GetMapping("{advertId}")
    fun getAdverts(@RequestParam customerId: UUID, @PathVariable advertId: UUID): ResponseEntity<OneAdvertResponse> {
        try {
            return ResponseEntity(service.getAdvertForCustomer(advertId), HttpStatus.OK)
        } catch (e: Exception) {
            throw ResponseStatusException(HttpStatus.BAD_REQUEST, e.message, e)
        }
    }
}