package br.com.rodrigogurgel.graphqlservice.inputs

import br.com.rodrigogurgel.graphqlservice.models.PetType

data class PetInput(
    val name: String,
    val type: PetType
)
