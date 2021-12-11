package br.com.rodrigogurgel.graphqlservice.repositories.impl

import br.com.rodrigogurgel.graphqlservice.models.Pet
import br.com.rodrigogurgel.graphqlservice.repositories.PetRepository
import br.com.rodrigogurgel.graphqlservice.repositories.mappers.PetMapper
import java.time.OffsetDateTime
import java.util.UUID
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.stereotype.Repository

@Repository
class PetRepositoryPGImpl(
    private val namedParameterJdbcTemplate: NamedParameterJdbcTemplate,
) : PetRepository {

    private final val findPetsByUserId = """
        select * from pet
        where user_id = :user_id
    """.trimIndent()

    private final val inserPet = """
        insert into pet (id, user_id, name, pet_type, created_at, updated_at)
        values (:id, :user_id, :name, :pet_type, :created_at, :updated_at)
        returning *
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
            inserPet,
            params,
            PetMapper()
        ).first()
    }
}