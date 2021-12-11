package br.com.rodrigogurgel.graphqlservice.services

import br.com.rodrigogurgel.graphqlservice.models.Pet
import java.util.UUID

interface PetService {

    fun findPetsByUserId(userId: UUID): List<Pet>

    fun createPet(userId: UUID, pet: Pet): Pet
}