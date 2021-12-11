package br.com.rodrigogurgel.graphqlservice.models

import java.util.UUID

data class Pet(
    val id: UUID,
    val name: String,
    val type: PetType
)
