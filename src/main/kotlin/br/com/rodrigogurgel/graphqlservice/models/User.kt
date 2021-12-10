package br.com.rodrigogurgel.graphqlservice.models

import java.time.OffsetDateTime
import java.util.UUID

data class User(
    val id: UUID?,
    val name: String? = null,
    val createdAt: OffsetDateTime? = null,
    val updatedAt: OffsetDateTime? = null
)
