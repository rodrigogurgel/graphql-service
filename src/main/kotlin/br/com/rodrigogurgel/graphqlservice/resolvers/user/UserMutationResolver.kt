package br.com.rodrigogurgel.graphqlservice.resolvers.user

import br.com.rodrigogurgel.graphqlservice.converters.UserConverter
import br.com.rodrigogurgel.graphqlservice.inputs.UserInput
import br.com.rodrigogurgel.graphqlservice.models.User
import br.com.rodrigogurgel.graphqlservice.services.UserService
import graphql.kickstart.tools.GraphQLMutationResolver
import org.springframework.stereotype.Component

@Component
class UserMutationResolver(
    private val userService: UserService
) : GraphQLMutationResolver {

    fun createUser(userInput: UserInput): User =
        userService.createUser(UserConverter.toModel(userInput))
}