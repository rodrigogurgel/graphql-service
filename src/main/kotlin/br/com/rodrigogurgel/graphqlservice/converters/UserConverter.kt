package br.com.rodrigogurgel.graphqlservice.converters

import br.com.rodrigogurgel.graphqlservice.inputs.UserInput
import br.com.rodrigogurgel.graphqlservice.models.User
import java.time.OffsetDateTime
import java.util.UUID

object UserConverter {
    fun toModel(userInput: UserInput): User =
        with(userInput) {
            User(
                id = id ?: UUID.randomUUID(),
                name = name,
                createdAt = OffsetDateTime.now(),
                updatedAt = OffsetDateTime.now()
            )
        }
}