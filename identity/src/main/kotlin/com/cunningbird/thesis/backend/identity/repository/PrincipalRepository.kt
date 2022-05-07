package com.cunningbird.thesis.backend.identity.repository

import com.cunningbird.thesis.backend.identity.entity.Principal
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface PrincipalRepository : JpaRepository<Principal, UUID> {
    fun findByUsername(username: String): Principal?
}