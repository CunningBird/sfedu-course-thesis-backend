package com.cunningbird.thesis.backend.core.repository

import com.cunningbird.thesis.backend.core.entity.service.Advert
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

//interface AdvertRepository : JpaRepository<Advert, UUID> {
//}

//    private val repository = arrayListOf(
//            OneServiceResponse(
//                UUID.fromString("bbe0fe62-38d1-11ec-8d3d-0242ac130003"),
//                "Awesome Advert 1",
//                222.33,
//                "Just awesome 1",
//                "https://via.placeholder.com/1200x900"
//            ),
//            OneServiceResponse(
//                UUID.fromString("bbe0fe62-38d1-11ec-8d3d-0242ac130004"),
//                "Awesome Advert 2",
//                322.33,
//                "Just awesome 2",
//                "https://via.placeholder.com/1200x900"
//            ),
//            OneServiceResponse(
//                UUID.fromString("bbe0fe62-38d1-11ec-8d3d-0242ac130005"),
//                "Awesome Advert 3",
//                422.33,
//                "Just awesome 3",
//                "https://via.placeholder.com/1200x900"
//            ),
//            OneServiceResponse(
//                UUID.fromString("bbe0fe62-38d1-11ec-8d3d-0242ac130006"),
//                "Awesome Advert 4",
//                522.33,
//                "Just awesome 4",
//                "https://via.placeholder.com/1200x900"
//            ),
//            OneServiceResponse(
//                UUID.fromString("bbe0fe62-38d1-11ec-8d3d-0242ac130007"),
//                "Awesome Advert 5",
//                622.33,
//                "Just awesome 5",
//                "https://via.placeholder.com/1200x900"
//            ),
//            OneServiceResponse(
//                UUID.fromString("bbe0fe62-38d1-11ec-8d3d-0242ac130008"),
//                "Awesome Advert 6",
//                722.33,
//                "Just awesome 6",
//                "https://via.placeholder.com/1200x900"
//            ),
//        )