package com.cunningbird.thesis.backend.core.entity

import java.util.*
import javax.persistence.*

@Entity
data class Advert(

    @Id
    @GeneratedValue
    @Column(name = "id", unique = true, nullable = false)
    var id: UUID? = null,

    var executorId: UUID? = null,

    var title: String? = null,
    var price: Double? = null,
    var address: String? = null,
    var description: String? = null,
    var image: String? = null,

//    @OneToMany(fetch = FetchType.EAGER, mappedBy = "advert", cascade = [CascadeType.ALL])
//    var appointments: MutableList<Appointment> = mutableListOf()
)
