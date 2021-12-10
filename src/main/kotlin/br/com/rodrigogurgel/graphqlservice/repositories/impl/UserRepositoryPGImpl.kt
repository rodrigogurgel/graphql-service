package br.com.rodrigogurgel.graphqlservice.repositories.impl

import br.com.rodrigogurgel.graphqlservice.exceptions.UserNotFoundException
import br.com.rodrigogurgel.graphqlservice.models.User
import br.com.rodrigogurgel.graphqlservice.repositories.UserRepository
import br.com.rodrigogurgel.graphqlservice.repositories.mappers.UserMapper
import java.time.OffsetDateTime
import java.util.UUID
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.stereotype.Repository

@Repository
class UserRepositoryPGImpl(
    private val namedParameterJdbcTemplate: NamedParameterJdbcTemplate,
) : UserRepository {
    private final val insertUser = """
        insert into "user" (id, name, created_at, updated_at)
        values (:id, :name, :created_at, :updated_at)
        returning *
    """.trimIndent()

    private final val selectUserById = """
        select *
        from "user"
        where id = :id;
    """.trimIndent()

    override fun createUser(user: User): User {
        val params = with(user) {
            mapOf(
                "id" to id,
                "name" to name,
                "created_at" to OffsetDateTime.now(),
                "updated_at" to OffsetDateTime.now()
            )
        }
        return namedParameterJdbcTemplate.query(
            insertUser,
            params,
            UserMapper()
        ).first()
    }

    override fun findUserById(id: UUID): User {
        return namedParameterJdbcTemplate.query(
            selectUserById,
            mapOf(
                "id" to id,
            ),
            UserMapper()
        ).firstOrNull() ?: throw UserNotFoundException("User not found: $id")
    }
}