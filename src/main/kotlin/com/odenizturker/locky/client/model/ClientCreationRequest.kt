package com.odenizturker.locky.client.model

import java.time.Instant

data class ClientCreationRequest(
    val clientId: String,
    val clientSecret: String,
    val clientSecretExpiresAt: Instant?,
    val clientName: String,
    val clientAuthenticationMethods: Set<AuthenticationMethod>,
    val authorizationGrantTypes: Set<GrantType>,
    val redirectUris: Set<String>,
    val postLogoutRedirectUris: Set<String>,
    val scopes: Set<String>,
    val clientSettings: ClientSettings,
    val tokenSettings: TokenSettings,
)
