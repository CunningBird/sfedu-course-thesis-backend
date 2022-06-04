package com.cunningbird.thesis.backend.core.controller.customer

import com.cunningbird.thesis.backend.core.dto.response.OneAdvertResponse
import com.cunningbird.thesis.backend.core.dto.response.ListAdvertsResponse
import com.cunningbird.thesis.backend.core.service.AdvertService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException
import java.util.*

@RestController("CustomerServiceController")
@RequestMapping("customer/adverts")
class AdvertController(
    private val service: AdvertService
) {
    @GetMapping
    fun getAdverts(@RequestHeader("customer_id") customerId: UUID): ResponseEntity<ListAdvertsResponse> {
        try {
            return ResponseEntity(service.getAdvertsForCustomer(), HttpStatus.OK)
        } catch (e: Exception) {
            throw ResponseStatusException(HttpStatus.BAD_REQUEST, e.message, e)
        }
    }

    @GetMapping("{advertId}")
    fun getAdverts(@RequestHeader("customer_id") customerId: UUID, @PathVariable advertId: UUID): ResponseEntity<OneAdvertResponse> {
        try {
            return ResponseEntity(service.getAdvertForCustomer(advertId), HttpStatus.OK)
        } catch (e: Exception) {
            throw ResponseStatusException(HttpStatus.BAD_REQUEST, e.message, e)
        }
    }
}