package com.odenizturker.locky.client.controller

import com.odenizturker.locky.client.model.ClientCreationRequest
import com.odenizturker.locky.client.model.ClientModel
import com.odenizturker.locky.client.service.ClientService
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
        @RequestBody clientCreationRequest: ClientCreationRequest,
    ): Unit = clientService.create(clientCreationRequest)

    @GetMapping("/{id}")
    suspend fun getById(
        @PathVariable id: UUID,
    ): ClientModel = clientService.getById(id)

    @GetMapping
    suspend fun getByClientId(
        @RequestParam clientId: String,
    ): ClientModel = clientService.getByClientId(clientId)
}
