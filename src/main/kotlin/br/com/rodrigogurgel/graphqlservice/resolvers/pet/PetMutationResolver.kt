package br.com.rodrigogurgel.graphqlservice.resolvers.pet

import br.com.rodrigogurgel.graphqlservice.converters.PetConverter
import br.com.rodrigogurgel.graphqlservice.inputs.PetInput
import br.com.rodrigogurgel.graphqlservice.models.Pet
import br.com.rodrigogurgel.graphqlservice.services.PetService
import graphql.kickstart.tools.GraphQLMutationResolver
import java.util.UUID
import org.springframework.stereotype.Component

@Component
class PetMutationResolver(
    private val petService: PetService
) : GraphQLMutationResolver {

    fun createPet(userId: UUID, petInput: PetInput): Pet =
        petService.createPet(userId, PetConverter.toModel(userId, petInput))
}