package br.com.rodrigogurgel.graphqlservice.models

import java.time.OffsetDateTime
import java.util.UUID

data class Pet(
    val id: UUID,
    val userId: UUID,
    val name: String,
    val type: PetType,
    val createdAt: OffsetDateTime,
    val updatedAt: OffsetDateTime
)
