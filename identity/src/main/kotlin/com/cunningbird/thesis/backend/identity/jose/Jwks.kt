package com.cunningbird.thesis.backend.identity.jose

import com.nimbusds.jose.jwk.Curve
import com.nimbusds.jose.jwk.ECKey
import com.nimbusds.jose.jwk.OctetSequenceKey
import com.nimbusds.jose.jwk.RSAKey
import com.cunningbird.thesis.backend.identity.jose.KeyGeneratorUtils.generateEcKey
import com.cunningbird.thesis.backend.identity.jose.KeyGeneratorUtils.generateRsaKey
import com.cunningbird.thesis.backend.identity.jose.KeyGeneratorUtils.generateSecretKey
import java.security.interfaces.ECPrivateKey
import java.security.interfaces.ECPublicKey
import java.security.interfaces.RSAPrivateKey
import java.security.interfaces.RSAPublicKey
import java.util.*

object Jwks {
    fun generateRsa(): RSAKey {
        val keyPair = generateRsaKey()
        val publicKey = keyPair.public as RSAPublicKey
        val privateKey = keyPair.private as RSAPrivateKey
        return RSAKey.Builder(publicKey)
            .privateKey(privateKey)
            .keyID(UUID.randomUUID().toString())
            .build()
    }

    fun generateEc(): ECKey {
        val keyPair = generateEcKey()
        val publicKey = keyPair.public as ECPublicKey
        val privateKey = keyPair.private as ECPrivateKey
        val curve = Curve.forECParameterSpec(publicKey.params)
        return ECKey.Builder(curve, publicKey)
            .privateKey(privateKey)
            .keyID(UUID.randomUUID().toString())
            .build()
    }

    fun generateSecret(): OctetSequenceKey {
        val secretKey = generateSecretKey()
        return OctetSequenceKey.Builder(secretKey)
            .keyID(UUID.randomUUID().toString())
            .build()
    }
}