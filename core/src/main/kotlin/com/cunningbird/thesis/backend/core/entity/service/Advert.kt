package com.cunningbird.thesis.backend.core.entity.service

import java.util.*
import javax.persistence.*

data class Advert(

//    @Id
//    @GeneratedValue
//    @Column(name = "id", unique = true, nullable = false)
    private var id: UUID? = null,

    private var executorId: UUID? = null,

    private var title: String? = null,
    private var price: Double? = null,
    private var address: String? = null,
    private var description: String? = null,
)
