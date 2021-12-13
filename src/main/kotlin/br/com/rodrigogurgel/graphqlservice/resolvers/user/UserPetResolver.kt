package br.com.rodrigogurgel.graphqlservice.resolvers.user

import br.com.rodrigogurgel.graphqlservice.models.Pet
import br.com.rodrigogurgel.graphqlservice.models.PetType
import br.com.rodrigogurgel.graphqlservice.models.User
import br.com.rodrigogurgel.graphqlservice.services.PetService
import graphql.kickstart.tools.GraphQLResolver
import org.springframework.stereotype.Component

@Component
class UserPetResolver (
    private val petService: PetService
) : GraphQLResolver<User> {

    fun pets(user: User): List<Pet> =
        petService.findPetsByUserId(user.id)

    fun petsWithType(user: User, type: PetType): List<Pet> =
        petService.findPetsByUserIdAndType(user.id, type)
}