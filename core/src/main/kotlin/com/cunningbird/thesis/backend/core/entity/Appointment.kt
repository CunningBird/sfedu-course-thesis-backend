package com.cunningbird.thesis.backend.core.entity

import java.util.*
import javax.persistence.*

@Entity
data class Appointment(

    @Id
    @GeneratedValue
    @Column(name = "id", unique = true, nullable = false)
    var id: UUID? = null,

    var customerId: UUID? = null,
    var executorId: UUID? = null,

    var date: Date? = null,

    @ManyToOne(fetch = FetchType.EAGER, cascade = [CascadeType.ALL])
    @JoinColumn(name = "advert_id", nullable = false)
    var advert: Advert? = null
)
