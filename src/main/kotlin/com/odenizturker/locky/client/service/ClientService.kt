package com.odenizturker.locky.client.service

import com.odenizturker.locky.client.entity.ClientEntity
import com.odenizturker.locky.client.model.ClientCreationRequest
import com.odenizturker.locky.client.model.ClientModel
import com.odenizturker.locky.client.repository.ClientRepository
import kotlinx.coroutines.reactor.awaitSingle
import kotlinx.coroutines.reactor.awaitSingleOrNull
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class ClientService(
    private val clientRepository: ClientRepository,
) {
    /*init {
        val defaultClient = ClientCreationRequest(
            clientId = "default-client",
            clientSecret = "secret",
            clientAuthenticationMethods = setOf(AuthenticationMethod.CLIENT_SECRET_BASIC),
            authorizationGrantTypes = setOf(GrantType.AUTHORIZATION_CODE, GrantType.REFRESH_TOKEN, GrantType.CLIENT_CREDENTIALS),
            redirectUris = setOf("http://localhost:8080/login/oauth2/code/default-client"),
            postLogoutRedirectUris = setOf("http://localhost:8080/"),
            scopes = setOf("openid", "profile"),
            clientSettings = ClientSettings(
                requireAuthorizationConsent = true,
                requireProofKey = null,
                jwkSetUrl = null,
                tokenEndpointAuthenticationSigningAlgorithm = null,
                x509CertificateSubjectDN = null,
            ),
            clientSecretExpiresAt = null,
            clientName = "default-client",
            tokenSettings = TokenSettings()
        )

        runBlocking{ create(defaultClient) }
    }*/

    suspend fun create(clientCreationRequest: ClientCreationRequest) {
        val clientEntity = clientRepository.findByClientId(clientCreationRequest.clientId).awaitSingleOrNull()
        if (clientEntity != null) {
            throw Exception()
        }
        clientRepository.save(ClientEntity(clientCreationRequest)).awaitSingle()
    }

    suspend fun getById(id: UUID): ClientModel {
        val clientEntity =
            clientRepository.findById(id).awaitSingleOrNull()
                ?: throw Exception()
        return ClientModel(clientEntity)
    }

    suspend fun getByClientId(clientId: String): ClientModel {
        val clientEntity =
            clientRepository.findByClientId(clientId).awaitSingleOrNull()
                ?: throw Exception()
        return ClientModel(clientEntity)
    }
}
