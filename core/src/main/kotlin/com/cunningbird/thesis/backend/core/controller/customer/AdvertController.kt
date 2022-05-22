package com.cunningbird.thesis.backend.core.controller.customer

import com.cunningbird.thesis.backend.core.dto.request.service.AppointServiceRequest
import com.cunningbird.thesis.backend.core.dto.response.service.OneServiceResponse
import com.cunningbird.thesis.backend.core.dto.response.service.ListServicesResponse
import com.cunningbird.thesis.backend.core.service.AdvertService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController("CustomerServiceController")
@RequestMapping("customer/services")
class AdvertController(
    private val service: AdvertService
) {
    @GetMapping
    fun getServices(@RequestParam customerId: UUID): ResponseEntity<ListServicesResponse> {
       val response = ListServicesResponse(UUID.randomUUID())
       return ResponseEntity(response, HttpStatus.OK)
    }

    @GetMapping("{serviceId}")
    fun getService(@RequestParam customerId: UUID, @PathVariable serviceId: UUID): ResponseEntity<OneServiceResponse> {
        val response = OneServiceResponse(UUID.randomUUID())
        return ResponseEntity(response, HttpStatus.OK)
    }

    @PostMapping("{serviceId}")
    fun appointService(@RequestParam customerId: UUID, @PathVariable serviceId: UUID, @RequestBody request: AppointServiceRequest) {

    }
}