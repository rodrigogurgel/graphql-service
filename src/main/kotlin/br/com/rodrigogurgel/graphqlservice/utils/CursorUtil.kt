package br.com.rodrigogurgel.graphqlservice.utils

import graphql.relay.Connection
import graphql.relay.ConnectionCursor
import graphql.relay.DefaultConnection
import graphql.relay.DefaultConnectionCursor
import graphql.relay.DefaultEdge
import graphql.relay.DefaultPageInfo
import graphql.relay.Edge
import java.nio.charset.StandardCharsets
import java.util.Base64
import java.util.UUID

object GraphqlConnectionUtil {
    fun encode(id: UUID): ConnectionCursor =
        DefaultConnectionCursor(Base64.getEncoder().encodeToString(id.toString().toByteArray(StandardCharsets.UTF_8)))

    fun <T> getFirstCursorFrom(edges: List<Edge<T>>): ConnectionCursor? {
        return if (edges.isEmpty()) null else edges.first().cursor
    }

    fun <T> getLastCursorFrom(edges: List<Edge<T>>): ConnectionCursor? {
        return if (edges.isEmpty()) null else edges.last().cursor
    }

    fun <T> connectionFromEdge(edges: List<Edge<T>>): Connection<T> {
        val firstCursor = GraphqlConnectionUtil.getFirstCursorFrom(edges)
        val lastCursor = GraphqlConnectionUtil.getLastCursorFrom(edges)

        val defaultPageInfo = DefaultPageInfo(
            firstCursor,
            lastCursor,
            cursor != null,
            edges.size >= first
        )

        return DefaultConnection(edges, defaultPageInfo)
    }
}