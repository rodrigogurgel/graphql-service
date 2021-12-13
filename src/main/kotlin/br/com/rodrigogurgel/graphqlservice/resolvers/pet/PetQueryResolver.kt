package br.com.rodrigogurgel.graphqlservice.resolvers.pet

import br.com.rodrigogurgel.graphqlservice.models.Pet
import br.com.rodrigogurgel.graphqlservice.services.PetService
import br.com.rodrigogurgel.graphqlservice.utils.CursorUtil
import graphql.kickstart.tools.GraphQLQueryResolver
import graphql.relay.Connection
import graphql.relay.DefaultConnection
import graphql.relay.DefaultEdge
import graphql.relay.DefaultPageInfo
import java.util.UUID
import org.springframework.stereotype.Component

@Component
class PetQueryResolver(
    private val petService: PetService
) : GraphQLQueryResolver {

    fun findPetById(id: UUID): Pet =
        petService.findPetById(id)

    fun findAllPets(): List<Pet> =
        petService.findAll()

    fun findPets(first: Int, cursor: String?): Connection<Pet> {
        val after = cursor?.let { CursorUtil.decode(it) }

        val pets = petService.findWithLimit(
            limit = first,
            after = after
        )

        val edges = pets.map {
            println("${it.createdAt} == ${CursorUtil.encode(it.createdAt)}")
            DefaultEdge(it, CursorUtil.encode(it.createdAt))
        }

        val defaultPageInfo = DefaultPageInfo(
            CursorUtil.getFirstCursorFrom(edges),
            CursorUtil.getLastCursorFrom(edges),
            cursor != null,
            edges.size >= first
        )

        return DefaultConnection(edges, defaultPageInfo)
    }
}
