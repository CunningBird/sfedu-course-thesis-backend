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
import kotlin.collections.ArrayList

@RestController("CustomerServiceController")
@RequestMapping("customer/services")
class AdvertController(
    private val service: AdvertService
) {

    private val services = listOf(
        OneServiceResponse(
            UUID.fromString("bbe0fe62-38d1-11ec-8d3d-0242ac130003"),
            "Awesome Advert 1",
            222.33,
            "Just awesome 1",
            "https://via.placeholder.com/1200x900"
        ),
        OneServiceResponse(
            UUID.fromString("bbe0fe62-38d1-11ec-8d3d-0242ac130004"),
            "Awesome Advert 2",
            322.33,
            "Just awesome 2",
            "https://via.placeholder.com/1200x900"
        ),
        OneServiceResponse(
            UUID.fromString("bbe0fe62-38d1-11ec-8d3d-0242ac130005"),
            "Awesome Advert 3",
            422.33,
            "Just awesome 3",
            "https://via.placeholder.com/1200x900"
        ),
        OneServiceResponse(
            UUID.fromString("bbe0fe62-38d1-11ec-8d3d-0242ac130006"),
            "Awesome Advert 4",
            522.33,
            "Just awesome 4",
            "https://via.placeholder.com/1200x900"
        ),
        OneServiceResponse(
            UUID.fromString("bbe0fe62-38d1-11ec-8d3d-0242ac130007"),
            "Awesome Advert 5",
            622.33,
            "Just awesome 5",
            "https://via.placeholder.com/1200x900"
        ),
        OneServiceResponse(
            UUID.fromString("bbe0fe62-38d1-11ec-8d3d-0242ac130008"),
            "Awesome Advert 6",
            722.33,
            "Just awesome 6",
            "https://via.placeholder.com/1200x900"
        ),
    )

    @GetMapping
    fun getServices(/*@RequestParam customerId: UUID*/): ResponseEntity<List<OneServiceResponse>> {
//       val response = ListServicesResponse(UUID.randomUUID())
//       return ResponseEntity(response, HttpStatus.OK)
        return ResponseEntity(services, HttpStatus.OK)
    }

    @GetMapping("{serviceId}")
    fun getService(/*@RequestParam customerId: UUID,*/ @PathVariable serviceId: UUID): ResponseEntity<OneServiceResponse> {
//        val response = OneServiceResponse(UUID.randomUUID())
//        return ResponseEntity(response, HttpStatus.OK)
        val service = services.find { it.id == serviceId } ?: return ResponseEntity(HttpStatus.NOT_FOUND)

        return ResponseEntity(service, HttpStatus.OK)
    }

    @PostMapping("{serviceId}")
    fun appointService(@RequestParam customerId: UUID, @PathVariable serviceId: UUID, @RequestBody request: AppointServiceRequest) {

    }
}