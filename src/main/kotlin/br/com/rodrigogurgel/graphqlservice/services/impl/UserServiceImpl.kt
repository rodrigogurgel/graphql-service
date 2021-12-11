package br.com.rodrigogurgel.graphqlservice.services.impl

import br.com.rodrigogurgel.graphqlservice.models.User
import br.com.rodrigogurgel.graphqlservice.repositories.UserRepository
import br.com.rodrigogurgel.graphqlservice.services.UserService
import java.time.OffsetDateTime
import java.util.UUID
import org.springframework.stereotype.Service

@Service
class UserServiceImpl(
    private val userRepository: UserRepository
) : UserService {
    override fun createUser(user: User): User =
        userRepository.createUser(user)

    override fun findUserById(id: UUID): User =
        userRepository.findUserById(id)

    override fun findAll(): List<User> =
        userRepository.findAll()

    override fun findWithLimit(limit: Int, after: OffsetDateTime?): List<User> {
        return if (after != null) userRepository.findAfterWithLimit(
            limit = limit,
            after = after
        ) else userRepository.findWithLimit(limit = limit)
    }
}