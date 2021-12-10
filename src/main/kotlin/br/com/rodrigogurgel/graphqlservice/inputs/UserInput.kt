package br.com.rodrigogurgel.graphqlservice.inputs

import java.util.UUID

data class UserInput(
    val id: UUID?,
    val name: String
)
