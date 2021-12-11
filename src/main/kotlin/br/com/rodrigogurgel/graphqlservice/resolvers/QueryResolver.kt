package br.com.rodrigogurgel.graphqlservice.resolvers

import br.com.rodrigogurgel.graphqlservice.models.User
import br.com.rodrigogurgel.graphqlservice.services.UserService
import graphql.kickstart.tools.GraphQLQueryResolver
import java.util.UUID
import org.springframework.stereotype.Component

@Component
class QueryResolver(
    private val userService: UserService
): GraphQLQueryResolver {

    fun users(): List<User> =
        userService.findAll()

    fun findUserById(id: UUID): User =
        userService.findUserById(id)
}
