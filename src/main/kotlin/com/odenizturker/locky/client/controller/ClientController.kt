package com.odenizturker.locky.client.controller

import com.odenizturker.locky.client.service.ClientService
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@RequestMapping("/clients")
class ClientController(
    private val clientService: ClientService,
) {
    @PostMapping
    suspend fun create(
        @RequestBody registeredClient: RegisteredClient,
    ): Unit = clientService.create(registeredClient)

    @GetMapping("/{id}")
    suspend fun getById(
        @PathVariable id: UUID,
    ): RegisteredClient = clientService.getById(id)

    @GetMapping
    suspend fun getByClientId(
        @RequestParam clientId: String,
    ): RegisteredClient = clientService.getByClientId(clientId)
}
