package com.cunningbird.thesis.backend.core.repository

import com.cunningbird.thesis.backend.core.entity.service.Advert
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

//interface AppointmentRepository : JpaRepository<Advert, UUID> {
//}

//    private val dateFormat = SimpleDateFormat("dd-MM-yyyy hh:mm")
//
//    private val repository = arrayListOf(
//        OneAppointmentResponse(
//            UUID.fromString("bbe0fe62-38d1-11ec-8d3d-0242a1130003"),
//            UUID.fromString("bbe0fe62-38d1-11ec-8d3d-0242ac130003"),
//            "Billy Herrington",
//            UUID.fromString("bbe0fe62-38d1-11ec-8d3d-0242ac130013"),
//            UUID.fromString("bbe0fe62-38d1-11ec-8d3d-0242ac130103"),
//            "Rostov-on-Don, Pushkina str, Kolotushkina building, 5 apt.",
//            false,
//            dateFormat.parse("26-01-2022 10:30"),
//            null,
//            "Very Gachi"
//        ),
//        OneAppointmentResponse(
//            UUID.fromString("bbe0fe62-38d1-11ec-8d3d-0242a1130003"),
//            UUID.fromString("bbe0fe62-38d1-11ec-8d3d-0242ac130003"),
//            "Billy Herrington",
//            UUID.fromString("bbe0fe62-38d1-11ec-8d3d-0242ac130013"),
//            UUID.fromString("bbe0fe62-38d1-11ec-8d3d-0242ac130103"),
//            "Rostov-on-Don, Pushkina str, Kolotushkina building, 5 apt.",
//            false,
//            dateFormat.parse("26-01-2022 11:00"),
//            null,
//            "Very Gachi"
//        ),
//        OneAppointmentResponse(
//            UUID.fromString("bbe0fe62-38d1-11ec-8d3d-0242a1130003"),
//            UUID.fromString("bbe0fe62-38d1-11ec-8d3d-0242ac130003"),
//            "Billy Herrington",
//            UUID.fromString("bbe0fe62-38d1-11ec-8d3d-0242ac130013"),
//            UUID.fromString("bbe0fe62-38d1-11ec-8d3d-0242ac130103"),
//            "Rostov-on-Don, Pushkina str, Kolotushkina building, 5 apt.",
//            false,
//            dateFormat.parse("26-01-2022 10:30"),
//            null,
//            "Very Gachi"
//        ),
//        OneAppointmentResponse(
//            UUID.fromString("bbe0fe62-38d1-11ec-8d3d-0242a1130003"),
//            UUID.fromString("bbe0fe62-38d1-11ec-8d3d-0242ac130003"),
//            "Billy Herrington",
//            UUID.fromString("bbe0fe62-38d1-11ec-8d3d-0242ac130013"),
//            UUID.fromString("bbe0fe62-38d1-11ec-8d3d-0242ac130103"),
//            "Rostov-on-Don, Pushkina str, Kolotushkina building, 5 apt.",
//            false,
//            dateFormat.parse("26-03-2022 9:30"),
//            null,
//            "Very Gachi"
//        ),
//        OneAppointmentResponse(
//            UUID.fromString("bbe0fe62-38d1-11ec-8d3d-0242a1130003"),
//            UUID.fromString("bbe0fe62-38d1-11ec-8d3d-0242ac130003"),
//            "Billy Herrington",
//            UUID.fromString("bbe0fe62-38d1-11ec-8d3d-0242ac130013"),
//            UUID.fromString("bbe0fe62-38d1-11ec-8d3d-0242ac130103"),
//            "Rostov-on-Don, Pushkina str, Kolotushkina building, 5 apt.",
//            false,
//            dateFormat.parse("26-02-2022 9:30"),
//            null,
//            "Very Gachi"
//        ),
//    )