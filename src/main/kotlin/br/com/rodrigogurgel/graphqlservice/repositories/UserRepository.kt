package br.com.rodrigogurgel.graphqlservice.repositories

import br.com.rodrigogurgel.graphqlservice.models.User
import java.time.OffsetDateTime
import java.util.UUID

interface UserRepository {

    fun createUser(user: User): User

    fun findAll(): List<User>

    fun findUserById(id: UUID): User

    fun findWithLimit(limit: Int): List<User>

    fun findAfterWithLimit(limit: Int, after: OffsetDateTime): List<User>
}