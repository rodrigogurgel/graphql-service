package br.com.rodrigogurgel.graphqlservice.models

import java.util.UUID

data class User(
    val id: UUID,
    val name: String,
)