package com.odenizturker.locky.client.entity

import com.odenizturker.locky.client.model.AuthenticationMethod
import com.odenizturker.locky.client.model.ClientCreationRequest
import com.odenizturker.locky.client.model.ClientSettings
import com.odenizturker.locky.client.model.GrantType
import com.odenizturker.locky.client.model.TokenSettings
import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.io.Serializable
import java.time.Instant
import java.util.UUID

@Table("clients")
data class ClientEntity(
    @Id
    val id: UUID? = null,
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
) : Serializable {
    constructor(client: ClientCreationRequest) : this(
        clientId = client.clientId,
        clientIdIssuedAt = Instant.now(),
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
