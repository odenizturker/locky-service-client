package com.odenizturker.locky.client.repository

import com.odenizturker.locky.client.entity.ClientEntity
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono
import java.util.UUID

@Service
interface ClientRepository : ReactiveCrudRepository<ClientEntity, UUID> {
    fun findByClientId(clientId: String): Mono<ClientEntity>
}
