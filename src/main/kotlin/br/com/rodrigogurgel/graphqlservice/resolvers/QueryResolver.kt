package br.com.rodrigogurgel.graphqlservice.resolvers

import br.com.rodrigogurgel.graphqlservice.models.Pet
import br.com.rodrigogurgel.graphqlservice.models.User
import br.com.rodrigogurgel.graphqlservice.services.PetService
import br.com.rodrigogurgel.graphqlservice.services.UserService
import graphql.kickstart.tools.GraphQLQueryResolver
import java.util.UUID
import org.springframework.stereotype.Component

@Component
class QueryResolver(
    private val userService: UserService,
    private val petService: PetService
): GraphQLQueryResolver {

    fun users(): List<User> =
        userService.findAll()

    fun findUserById(id: UUID): User =
        userService.findUserById(id)

    fun findPetById(id: UUID): Pet =
        petService.findPetById(id)
}
