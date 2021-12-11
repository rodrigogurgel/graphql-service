package br.com.rodrigogurgel.graphqlservice.resolvers

import br.com.rodrigogurgel.graphqlservice.models.Pet
import br.com.rodrigogurgel.graphqlservice.models.User
import br.com.rodrigogurgel.graphqlservice.services.PetService
import br.com.rodrigogurgel.graphqlservice.services.UserService
import graphql.kickstart.tools.GraphQLResolver
import org.springframework.stereotype.Component

@Component
class PetResolver(
    private val petService: PetService,
    private val userService: UserService
) : GraphQLResolver<Pet> {

    fun pets(user: User): List<Pet> =
        petService.findPetsByUserId(user.id)

    fun user(pet: Pet): User =
        userService.findUserById(pet.userId!!)
}