package com.cunningbird.thesis.backend.identity.repository

import org.springframework.security.oauth2.core.AuthorizationGrantType
import org.springframework.security.oauth2.core.ClientAuthenticationMethod
import org.springframework.security.oauth2.core.oidc.OidcScopes
import org.springframework.security.oauth2.server.authorization.client.InMemoryRegisteredClientRepository
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient
import org.springframework.security.oauth2.server.authorization.client.RegisteredClientRepository
import java.util.*

class RegisteredClientRepositoryImpl : RegisteredClientRepository {

    private val repository: RegisteredClientRepository

    init {
        val registeredClient0 = RegisteredClient.withId(UUID.randomUUID().toString())
            .clientId("test-application")
            .clientSecret("{noop}123456")
            .clientAuthenticationMethod(ClientAuthenticationMethod.CLIENT_SECRET_POST)
            .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
            .redirectUri("https://oidcdebugger.com/debug")
            .scope(OidcScopes.OPENID)
            .scope("executor")
            .scope("customer")
            .build()

        val registeredClient1 = RegisteredClient.withId(UUID.randomUUID().toString())
            .clientId("executor-application")
            .clientSecret("{noop}secret1")
            .clientAuthenticationMethod(ClientAuthenticationMethod.CLIENT_SECRET_POST)
            .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
            .redirectUri("http://samplecallback.com/")
            .scope(OidcScopes.OPENID)
            .scope("executor")
            .build()

        val registeredClient2 = RegisteredClient.withId(UUID.randomUUID().toString())
            .clientId("customer-application")
            .clientSecret("{noop}secret2")
            .clientAuthenticationMethod(ClientAuthenticationMethod.CLIENT_SECRET_POST)
            .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
            .redirectUri("http://samplecallback1.com/")
            .scope(OidcScopes.OPENID)
            .scope("customer")
            .build()

        repository = InMemoryRegisteredClientRepository(registeredClient0, registeredClient1, registeredClient2)
    }

    override fun save(registeredClient: RegisteredClient) {
        repository.save(registeredClient)
    }

    override fun findById(id: String): RegisteredClient? {
        return repository.findById(id)
    }

    override fun findByClientId(clientId: String): RegisteredClient? {
        return repository.findByClientId(clientId)
    }
}