package com.odenizturker.locky.client.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.web.SecurityFilterChain

@Configuration
@EnableWebSecurity
class ResourceServerConfig(
    @Value("\${spring.security.oauth2.resourceserver.jwt.jwk-set-uri}")
    private val jwkSetUri: String,
) {
    @Bean
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain =
        http
            .authorizeHttpRequests {
                it.anyRequest().authenticated()
            }.oauth2ResourceServer {
                it.jwt { jwt ->
                    jwt.jwkSetUri(jwkSetUri)
                }
            }.build()
}
