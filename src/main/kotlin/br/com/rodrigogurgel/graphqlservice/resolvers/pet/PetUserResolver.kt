package br.com.rodrigogurgel.graphqlservice.resolvers.pet

import br.com.rodrigogurgel.graphqlservice.models.Pet
import br.com.rodrigogurgel.graphqlservice.models.User
import br.com.rodrigogurgel.graphqlservice.services.UserService
import graphql.kickstart.tools.GraphQLResolver
import org.springframework.stereotype.Component

@Component
class PetUserResolver(
    private val userService: UserService
) : GraphQLResolver<Pet> {

    fun user(pet: Pet): User {
        return userService.findUserById(pet.userId)
    }

}