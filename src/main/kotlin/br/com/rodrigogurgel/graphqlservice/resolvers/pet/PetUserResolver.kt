package br.com.rodrigogurgel.graphqlservice.resolvers.pet

import br.com.rodrigogurgel.graphqlservice.models.Pet
import br.com.rodrigogurgel.graphqlservice.models.User
import br.com.rodrigogurgel.graphqlservice.services.UserService
import graphql.execution.DataFetcherResult
import graphql.kickstart.execution.error.GenericGraphQLError
import graphql.kickstart.tools.GraphQLResolver
import org.springframework.stereotype.Component

@Component
class PetUserResolver(
    private val userService: UserService
) : GraphQLResolver<Pet> {

    fun user(pet: Pet): DataFetcherResult<User> {
        val user = userService.findUserById(pet.userId)
        return DataFetcherResult.newResult<User>()
            .data(user.copy(name = ""))
            .error(GenericGraphQLError("Name not available"))
            .build()
    }

}