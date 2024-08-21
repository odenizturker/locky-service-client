package com.odenizturker.locky.client.model

import org.springframework.security.oauth2.jose.jws.SignatureAlgorithm
import java.time.Duration

data class TokenSettings(
    val reuseRefreshTokens: Boolean = false,
    val x509CertificateBoundAccessTokens: Boolean = false,
    val accessTokenFormat: OAuth2TokenFormat = OAuth2TokenFormat.SELF_CONTAINED,
    val accessTokenTimeToLive: Duration = Duration.ofMinutes(5),
    val authorizationCodeTimeToLive: Duration = Duration.ofMinutes(1),
    val deviceCodeTimeToLive: Duration = Duration.ofMinutes(1),
    val idTokenSignatureAlgorithm: SignatureAlgorithm = SignatureAlgorithm.RS256,
    val refreshTokenTimeToLive: Duration = Duration.ofMinutes(30),
) {
    enum class OAuth2TokenFormat {
        SELF_CONTAINED,
        REFERENCE,
    }
}
