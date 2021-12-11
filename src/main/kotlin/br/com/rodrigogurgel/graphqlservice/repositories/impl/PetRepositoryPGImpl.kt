package br.com.rodrigogurgel.graphqlservice.repositories.impl

import br.com.rodrigogurgel.graphqlservice.exceptions.PetNotFoundException
import br.com.rodrigogurgel.graphqlservice.models.Pet
import br.com.rodrigogurgel.graphqlservice.models.PetType
import br.com.rodrigogurgel.graphqlservice.models.User
import br.com.rodrigogurgel.graphqlservice.repositories.PetRepository
import br.com.rodrigogurgel.graphqlservice.repositories.mappers.PetMapper
import br.com.rodrigogurgel.graphqlservice.repositories.mappers.UserMapper
import java.time.OffsetDateTime
import java.util.UUID
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.stereotype.Repository

@Repository
class PetRepositoryPGImpl(
    private val namedParameterJdbcTemplate: NamedParameterJdbcTemplate,
) : PetRepository {

    private final val findAllPet = """
        select * from pet
    """.trimIndent()

    private final val findPetsByUserId = """
        select * from pet
        where user_id = :user_id
    """.trimIndent()

    private final val findPetsByUserIdAndType = """
        $findPetsByUserId
        and pet_type = :type
    """.trimIndent()

    private final val insertPet = """
        insert into pet (id, user_id, name, pet_type, created_at, updated_at)
        values (:id, :user_id, :name, :pet_type, :created_at, :updated_at)
        returning *
    """.trimIndent()

    private final val findPetId = """
        select * from pet
        where id = :id
    """.trimIndent()

    private final val selectWithLimit = """
        select * from pet
        limit :limit
    """.trimIndent()

    private final val selectAfterCreatedAtWithLimit = """
        select * from pet
        where created_at > :after
        limit :limit
    """.trimIndent()

    override fun findPetsByUserId(userId: UUID): List<Pet> =
        namedParameterJdbcTemplate.query(
            findPetsByUserId,
            mapOf("user_id" to userId),
            PetMapper()
        )

    override fun createPet(userId: UUID, pet: Pet): Pet {
        val params = with(pet) {
            mapOf(
                "id" to id,
                "name" to name,
                "pet_type" to type.name,
                "created_at" to OffsetDateTime.now(),
                "updated_at" to OffsetDateTime.now(),
                "user_id" to userId
            )
        }
        return namedParameterJdbcTemplate.query(
            insertPet,
            params,
            PetMapper()
        ).first()
    }

    override fun findPetById(id: UUID): Pet {
        return namedParameterJdbcTemplate.query(
            findPetId,
            mapOf(
                "id" to id
            ),
            PetMapper()
        ).firstOrNull() ?: throw PetNotFoundException("Pet Not Found! id: $id")
    }

    override fun findPetsByUserIdAndType(userId: UUID, type: PetType): List<Pet> =
        namedParameterJdbcTemplate.query(
            findPetsByUserIdAndType,
            mapOf(
                "user_id" to userId,
                "type" to type.name
            ),
            PetMapper()
        )

    override fun findAll(): List<Pet> =
        namedParameterJdbcTemplate.query(
            findAllPet,
            PetMapper()
        )

    override fun findWithLimit(limit: Int): List<Pet> {
        return namedParameterJdbcTemplate.query(
            selectWithLimit,
            mapOf(
                "limit" to limit
            ),
            PetMapper()
        )
    }


    override fun findAfterWithLimit(limit: Int, after: OffsetDateTime): List<Pet> =
        namedParameterJdbcTemplate.query(
            selectAfterCreatedAtWithLimit,
            mapOf(
                "after" to after,
                "limit" to limit
            ),
            PetMapper()
        )
}