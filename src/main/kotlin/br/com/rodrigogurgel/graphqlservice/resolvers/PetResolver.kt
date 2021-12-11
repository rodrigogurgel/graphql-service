package br.com.rodrigogurgel.graphqlservice.resolvers

import br.com.rodrigogurgel.graphqlservice.models.Pet
import br.com.rodrigogurgel.graphqlservice.models.User
import br.com.rodrigogurgel.graphqlservice.services.PetService
import graphql.kickstart.tools.GraphQLResolver
import org.springframework.stereotype.Component

@Component
class PetResolver(
    private val petService: PetService
) : GraphQLResolver<Pet> {

    fun pets(user: User): List<Pet> =
        petService.findPetsByUserId(user.id)
}