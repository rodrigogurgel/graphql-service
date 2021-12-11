package br.com.rodrigogurgel.graphqlservice.services

import br.com.rodrigogurgel.graphqlservice.models.User
import java.util.UUID

interface UserService {
    fun createUser(user: User): User
    fun findUserById(id: UUID): User
    fun findAll(): List<User>
}