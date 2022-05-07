package com.cunningbird.thesis.backend.identity.entity

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import java.util.*
import javax.persistence.*

/**
 * Данные авторизации пользователя
 */
@Entity
@Table(name = "users")
class Principal(

    @Id
    @GeneratedValue
    @Column(name = "id", unique = true, nullable = false)
    private var id: UUID? = null,

    @Column(name = "username", unique = true, nullable = false)
    private var username: String? = null,

    @Column(name = "password", nullable = false)
    private var password: String? = null,

    //private var authorities: MutableCollection<GrantedAuthority>
) : UserDetails {

    // TODO get as field
    override fun getAuthorities(): MutableCollection<out GrantedAuthority> {
        return mutableListOf(
            SimpleGrantedAuthority("SCOPE_executor"),
            SimpleGrantedAuthority("SCOPE_customer")
        )
    }

    override fun getPassword(): String {
        return password!!
    }

    override fun getUsername(): String {
        return username!!
    }

    override fun isAccountNonExpired(): Boolean {
        return true
    }

    override fun isAccountNonLocked(): Boolean {
        return true
    }

    override fun isCredentialsNonExpired(): Boolean {
        return true
    }

    override fun isEnabled(): Boolean {
        return true
    }
}