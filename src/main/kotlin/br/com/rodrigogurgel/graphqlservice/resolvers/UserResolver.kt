package br.com.rodrigogurgel.graphqlservice.resolvers

import br.com.rodrigogurgel.graphqlservice.converters.UserConverter
import br.com.rodrigogurgel.graphqlservice.inputs.UserInput
import br.com.rodrigogurgel.graphqlservice.models.User
import br.com.rodrigogurgel.graphqlservice.services.UserService
import br.com.rodrigogurgel.graphqlservice.utils.DataFetchingEnvironmentUtils.selectedFields
import graphql.kickstart.tools.GraphQLMutationResolver
import graphql.kickstart.tools.GraphQLQueryResolver
import graphql.schema.DataFetchingEnvironment
import java.util.UUID
import org.springframework.stereotype.Component

@Component
class UserResolver(
    private val userService: UserService
) : GraphQLQueryResolver, GraphQLMutationResolver {
    fun createUser(userInput: UserInput, environment: DataFetchingEnvironment): User =
        userService.createUser(UserConverter.toModel(userInput))

    fun findUserById(id: UUID, environment: DataFetchingEnvironment): User {
        val selectedFields = environment.selectedFields()
        return userService.findUserById(id)
    }
}