package com.cunningbird.thesis.backend.core.controller.executor

import com.cunningbird.thesis.backend.core.dto.request.service.CreateServiceRequest
import com.cunningbird.thesis.backend.core.dto.request.service.UpdateServiceRequest
import com.cunningbird.thesis.backend.core.dto.response.service.ListServicesResponse
import com.cunningbird.thesis.backend.core.dto.response.service.OneServiceResponse
import com.cunningbird.thesis.backend.core.service.AdvertService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController("ExecutorServiceController")
@RequestMapping("executor/services")
class AdvertController(
    private val service: AdvertService
) {

    @GetMapping
    fun getServices(@RequestParam executorId: UUID): ResponseEntity<ListServicesResponse> {

        val response = ListServicesResponse(UUID.randomUUID())
        return ResponseEntity(response, HttpStatus.OK)
    }

    @GetMapping("{serviceId}")
    fun getService(@RequestParam executorId: UUID, @PathVariable serviceId: UUID): ResponseEntity<OneServiceResponse?> {

        val response = OneServiceResponse(UUID.randomUUID())
        return ResponseEntity(response, HttpStatus.OK)
    }

    @PatchMapping("{serviceId}")
    fun updateService(@RequestParam executorId: UUID, @PathVariable serviceId: UUID, @RequestBody request: UpdateServiceRequest) {

    }

    @PostMapping
    fun createService(@RequestParam executorId: UUID, @RequestBody request: CreateServiceRequest) {

    }
}