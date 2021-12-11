package br.com.rodrigogurgel.graphqlservice.resolvers

import br.com.rodrigogurgel.graphqlservice.models.Pet
import br.com.rodrigogurgel.graphqlservice.models.User
import br.com.rodrigogurgel.graphqlservice.services.PetService
import br.com.rodrigogurgel.graphqlservice.services.UserService
import br.com.rodrigogurgel.graphqlservice.utils.CursorUtil
import graphql.kickstart.tools.GraphQLQueryResolver
import graphql.relay.Connection
import graphql.relay.DefaultConnection
import graphql.relay.DefaultEdge
import graphql.relay.DefaultPageInfo
import java.time.OffsetDateTime
import java.time.ZoneOffset
import java.util.UUID
import org.springframework.stereotype.Component

@Component
class QueryResolver(
    private val userService: UserService,
    private val petService: PetService
) : GraphQLQueryResolver {

    fun users(): List<User> =
        userService.findAll()

    fun findUserById(id: UUID): User =
        userService.findUserById(id)

    fun findPetById(id: UUID): Pet =
        petService.findPetById(id)

    fun pets(): List<Pet> =
        petService.findAll()

    fun users(first: Int, cursor: String?): Connection<User> {
        val after = cursor?.let { CursorUtil.decode(it) }

        val users = userService.findWithLimit(
            limit = first,
            after = after
        )

        val edges = users.map {
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

    fun pets(first: Int, cursor: String?): Connection<Pet> {
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
