package com.odenizturker.locky.client.model

import com.odenizturker.locky.client.entity.ClientEntity
import java.time.Instant
import java.util.UUID

data class ClientModel(
    val id: UUID,
    val clientId: String,
    val clientIdIssuedAt: Instant?,
    val clientSecret: String?,
    val clientSecretExpiresAt: Instant?,
    val clientName: String,
    val clientAuthenticationMethods: Set<AuthenticationMethod>,
    val authorizationGrantTypes: Set<GrantType>,
    val redirectUris: Set<String>,
    val postLogoutRedirectUris: Set<String>,
    val scopes: Set<String>,
    val clientSettings: ClientSettings,
    val tokenSettings: TokenSettings,
) {
    constructor(client: ClientEntity) : this(
        id = client.id!!,
        clientId = client.clientId,
        clientIdIssuedAt = client.clientIdIssuedAt,
        clientSecret = client.clientSecret,
        clientSecretExpiresAt = client.clientSecretExpiresAt,
        clientName = client.clientName,
        clientAuthenticationMethods = client.clientAuthenticationMethods,
        authorizationGrantTypes = client.authorizationGrantTypes,
        redirectUris = client.redirectUris,
        postLogoutRedirectUris = client.postLogoutRedirectUris,
        scopes = client.scopes,
        clientSettings = client.clientSettings,
        tokenSettings = client.tokenSettings,
    )
}
