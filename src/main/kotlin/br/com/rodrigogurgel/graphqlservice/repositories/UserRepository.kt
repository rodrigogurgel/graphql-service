package br.com.rodrigogurgel.graphqlservice.repositories

import br.com.rodrigogurgel.graphqlservice.models.User
import java.util.UUID

interface UserRepository {
    fun createUser(user: User): User
    fun findUserById(id: UUID): User
}