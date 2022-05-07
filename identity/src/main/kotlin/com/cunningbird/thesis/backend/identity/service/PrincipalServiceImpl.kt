package com.cunningbird.thesis.backend.identity.service

import com.cunningbird.thesis.backend.identity.repository.PrincipalRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service
import java.util.*

@Service
class PrincipalServiceImpl(
    private val repository: PrincipalRepository
) : UserDetailsService {

    @Throws(UsernameNotFoundException::class)
    override fun loadUserByUsername(username: String): UserDetails {
        return repository.findByUsername(username.lowercase(Locale.getDefault()))
            ?: throw UsernameNotFoundException(username)
    }
}