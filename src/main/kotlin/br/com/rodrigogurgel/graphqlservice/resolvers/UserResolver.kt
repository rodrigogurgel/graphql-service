package br.com.rodrigogurgel.graphqlservice.resolvers

import br.com.rodrigogurgel.graphqlservice.models.Pet
import br.com.rodrigogurgel.graphqlservice.models.PetType
import br.com.rodrigogurgel.graphqlservice.models.User
import br.com.rodrigogurgel.graphqlservice.services.PetService
import br.com.rodrigogurgel.graphqlservice.services.UserService
import graphql.kickstart.tools.GraphQLResolver
import org.springframework.stereotype.Component

@Component
class UserResolver(
    private val userService: UserService,
    private val petService: PetService
) : GraphQLResolver<User> {

    fun pets(user: User): List<Pet> =
        petService.findPetsByUserId(user.id)

    fun users(): List<User> =
        userService.findAll()

    fun petsWithType(user: User, type: PetType): List<Pet> =
        petService.findPetsByUserIdAndType(user.id, type)
}