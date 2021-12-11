package br.com.rodrigogurgel.graphqlservice.converters

import br.com.rodrigogurgel.graphqlservice.inputs.PetInput
import br.com.rodrigogurgel.graphqlservice.models.Pet
import java.util.UUID

object PetConverter {

    fun toModel(petInput: PetInput): Pet =
        with(petInput) {
            Pet(
                id = UUID.randomUUID(),
                name = name,
                type = type
            )
        }
}