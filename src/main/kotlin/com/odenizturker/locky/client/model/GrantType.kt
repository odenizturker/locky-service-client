package com.odenizturker.locky.client.model

enum class GrantType(
    val value: String,
) {
    AUTHORIZATION_CODE("authorization_code"),
    REFRESH_TOKEN("refresh_token"),
    CLIENT_CREDENTIALS("client_credentials"),
}
