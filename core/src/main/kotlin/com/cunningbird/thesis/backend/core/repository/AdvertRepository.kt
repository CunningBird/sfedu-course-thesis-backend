package com.cunningbird.thesis.backend.core.repository

import com.cunningbird.thesis.backend.core.entity.Advert
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface AdvertRepository : JpaRepository<Advert, UUID>