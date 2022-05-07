package com.cunningbird.thesis.backend.identity.config

import com.nimbusds.jose.jwk.JWKSet
import com.nimbusds.jose.jwk.RSAKey
import com.nimbusds.jose.jwk.source.JWKSource
import com.nimbusds.jose.proc.SecurityContext
import com.cunningbird.thesis.backend.identity.jose.Jwks
import com.cunningbird.thesis.backend.identity.repository.RegisteredClientRepositoryImpl
import org.springframework.context.annotation.Bean
import org.springframework.core.Ordered
import org.springframework.core.annotation.Order
import org.springframework.security.authentication.dao.DaoAuthenticationProvider
import org.springframework.security.config.Customizer
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.OAuth2AuthorizationServerConfiguration
import org.springframework.security.config.annotation.web.configurers.oauth2.server.authorization.OAuth2AuthorizationServerConfigurer
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.oauth2.jwt.JwtDecoder
import org.springframework.security.oauth2.server.authorization.client.RegisteredClientRepository
import org.springframework.security.oauth2.server.authorization.config.ProviderSettings
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.util.matcher.AntPathRequestMatcher
import javax.annotation.Resource

@EnableWebSecurity
class WebSecurityConfig(
    private val config: AuthorizationServerConfig,

    @Resource
    private val userDetailsService: UserDetailsService
) {

    /**
     * Конфигурация авторизации в приложении для пользователей
     */
    @Bean
    @Throws(Exception::class)
    fun defaultSecurityFilterChain(http: HttpSecurity): SecurityFilterChain {
        http.authorizeRequests { authorizeRequests -> authorizeRequests.anyRequest().authenticated() }
            .formLogin(Customizer.withDefaults())
            .logout().logoutRequestMatcher(AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login")
            .deleteCookies("remember-me")

        return http.build()
    }

    @Bean
    @Order(Ordered.HIGHEST_PRECEDENCE)
    @Throws(Exception::class)
    fun authorizationServerSecurityFilterChain(http: HttpSecurity): SecurityFilterChain {
        val authorizationServerConfigurer = OAuth2AuthorizationServerConfigurer<HttpSecurity>()
        val endpointsMatcher = authorizationServerConfigurer.endpointsMatcher

        http.requestMatcher(endpointsMatcher)
            .authorizeRequests { authorizeRequests -> authorizeRequests.anyRequest().authenticated() }
        http.csrf { csrf -> csrf.ignoringRequestMatchers(endpointsMatcher) }

        http.apply(authorizationServerConfigurer)
        http.formLogin(Customizer.withDefaults())
            .logout()
            .logoutRequestMatcher(AntPathRequestMatcher("/logout"))
            .logoutSuccessUrl("/login")
            .deleteCookies("remember-me")

        return http.build()
    }

    // TODO Save all data from OAuth2 in database

    @Bean
    fun registeredClientRepository(): RegisteredClientRepository {
        return RegisteredClientRepositoryImpl()
    }

    @Bean
    fun providerSettings(): ProviderSettings {
        return ProviderSettings.builder()
            .issuer(config.providerName)
            .build()
    }

    @Bean
    fun jwtDecoder(jwkSource: JWKSource<SecurityContext>): JwtDecoder {
        return OAuth2AuthorizationServerConfiguration.jwtDecoder(jwkSource)
    }

    @Bean
    fun jwkSource(): JWKSource<SecurityContext> {
        val rsaKey: RSAKey = Jwks.generateRsa()
        val jwkSet = JWKSet(rsaKey)
        return JWKSource { jwkSelector, securityContext -> jwkSelector.select(jwkSet) }
    }

    @Bean
    fun authProvider(): DaoAuthenticationProvider {
        val authProvider = DaoAuthenticationProvider()
        authProvider.setUserDetailsService(userDetailsService)
        authProvider.setPasswordEncoder(BCryptPasswordEncoder())
        return authProvider
    }

    @Throws(java.lang.Exception::class)
    protected fun configure(auth: AuthenticationManagerBuilder) {
        auth.authenticationProvider(authProvider())
    }
}