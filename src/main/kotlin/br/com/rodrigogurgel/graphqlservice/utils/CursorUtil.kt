package br.com.rodrigogurgel.graphqlservice.utils

import graphql.relay.ConnectionCursor
import graphql.relay.DefaultConnectionCursor
import graphql.relay.Edge
import java.time.OffsetDateTime
import java.util.Base64

object CursorUtil {
    fun encode(createdAt: OffsetDateTime): ConnectionCursor =
        DefaultConnectionCursor(
            Base64.getEncoder().encodeToString(createdAt.toString().encodeToByteArray())
        )

    fun decode(cursor: String): OffsetDateTime {
        return OffsetDateTime.parse(String(Base64.getDecoder().decode(cursor)))
    }

    fun <T> getFirstCursorFrom(edges: List<Edge<T>>): ConnectionCursor? {
        return if (edges.isEmpty()) null else edges.first().cursor
    }

    fun <T> getLastCursorFrom(edges: List<Edge<T>>): ConnectionCursor? {
        return if (edges.isEmpty()) null else edges.last().cursor
    }
}