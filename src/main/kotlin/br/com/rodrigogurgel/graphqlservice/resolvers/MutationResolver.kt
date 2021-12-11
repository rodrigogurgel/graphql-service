package br.com.rodrigogurgel.graphqlservice.resolvers

import br.com.rodrigogurgel.graphqlservice.converters.PetConverter
import br.com.rodrigogurgel.graphqlservice.converters.UserConverter
import br.com.rodrigogurgel.graphqlservice.inputs.PetInput
import br.com.rodrigogurgel.graphqlservice.inputs.UserInput
import br.com.rodrigogurgel.graphqlservice.models.Pet
import br.com.rodrigogurgel.graphqlservice.models.User
import br.com.rodrigogurgel.graphqlservice.services.PetService
import br.com.rodrigogurgel.graphqlservice.services.UserService
import graphql.kickstart.tools.GraphQLMutationResolver
import java.util.UUID
import org.springframework.stereotype.Component

@Component
class MutationResolver(
    private val userService: UserService,
    private val petService: PetService
) : GraphQLMutationResolver {

    fun createUser(userInput: UserInput): User =
        userService.createUser(UserConverter.toModel(userInput))

    fun createPet(userId: UUID, petInput: PetInput): Pet =
        petService.createPet(userId, PetConverter.toModel(petInput))
}