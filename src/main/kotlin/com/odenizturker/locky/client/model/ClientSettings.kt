package com.odenizturker.locky.client.model

import org.springframework.security.oauth2.jose.jws.JwsAlgorithm

data class ClientSettings(
    val requireProofKey: Boolean?,
    val requireAuthorizationConsent: Boolean?,
    val jwkSetUrl: String?,
    val tokenEndpointAuthenticationSigningAlgorithm: JwsAlgorithm?,
    val x509CertificateSubjectDN: String?,
)
