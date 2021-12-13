package br.com.rodrigogurgel.graphqlservice.resolvers.user

import br.com.rodrigogurgel.graphqlservice.models.User
import br.com.rodrigogurgel.graphqlservice.services.UserService
import br.com.rodrigogurgel.graphqlservice.utils.CursorUtil
import graphql.kickstart.tools.GraphQLQueryResolver
import graphql.relay.Connection
import graphql.relay.DefaultConnection
import graphql.relay.DefaultEdge
import graphql.relay.DefaultPageInfo
import java.util.UUID
import org.springframework.stereotype.Component

@Component
class UserQueryResolver(
    private val userService: UserService,
) : GraphQLQueryResolver {
    fun findAllUsers(): List<User> =
        userService.findAll()

    fun findUserById(id: UUID): User =
        userService.findUserById(id)

    fun findUsers(first: Int, cursor: String?): Connection<User> {
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

}