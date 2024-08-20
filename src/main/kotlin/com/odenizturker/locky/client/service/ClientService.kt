package com.odenizturker.locky.client.service

import com.fasterxml.jackson.databind.ObjectMapper
import com.odenizturker.locky.client.entity.ClientEntity
import com.odenizturker.locky.client.repository.ClientRepository
import kotlinx.coroutines.reactor.awaitSingle
import kotlinx.coroutines.reactor.awaitSingleOrNull
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class ClientService(
    private val objectMapper: ObjectMapper,
    private val clientRepository: ClientRepository,
) {
    suspend fun create(registeredClient: RegisteredClient) {
        clientRepository.save(ClientEntity(registeredClient)).awaitSingle()
    }

    suspend fun getById(id: UUID): RegisteredClient =
        clientRepository.findById(id).awaitSingleOrNull()?.toRegisteredClient(objectMapper)
            ?: throw Exception()

    suspend fun getByClientId(clientId: String): RegisteredClient =
        clientRepository.findByClientId(clientId).awaitSingleOrNull()?.toRegisteredClient(objectMapper)
            ?: throw Exception()
}
