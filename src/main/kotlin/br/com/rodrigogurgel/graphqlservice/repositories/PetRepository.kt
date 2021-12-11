package br.com.rodrigogurgel.graphqlservice.repositories

import br.com.rodrigogurgel.graphqlservice.models.Pet
import java.util.UUID

interface PetRepository {

    fun findPetsByUserId(userId: UUID): List<Pet>

    fun createPet(userId: UUID, pet: Pet): Pet

    fun findPetById(id: UUID): Pet
}