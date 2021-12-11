package br.com.rodrigogurgel.graphqlservice.services.impl

import br.com.rodrigogurgel.graphqlservice.models.Pet
import br.com.rodrigogurgel.graphqlservice.models.PetType
import br.com.rodrigogurgel.graphqlservice.repositories.PetRepository
import br.com.rodrigogurgel.graphqlservice.services.PetService
import java.time.OffsetDateTime
import java.util.UUID
import org.springframework.stereotype.Service

@Service
class PetServiceImpl(
    private val petRepository: PetRepository
) : PetService {

    override fun findPetsByUserId(userId: UUID): List<Pet> =
        petRepository.findPetsByUserId(userId)

    override fun createPet(userId: UUID, pet: Pet): Pet =
        petRepository.createPet(userId, pet)

    override fun findPetById(id: UUID): Pet =
        petRepository.findPetById(id)

    override fun findPetsByUserIdAndType(userId: UUID, type: PetType): List<Pet> =
        petRepository.findPetsByUserIdAndType(userId, type)

    override fun findAll(): List<Pet> =
        petRepository.findAll()

    override fun findWithLimit(limit: Int, after: OffsetDateTime?): List<Pet> {
        return if (after != null) petRepository.findAfterWithLimit(
            limit = limit,
            after = after
        ) else petRepository.findWithLimit(limit = limit)
    }
}