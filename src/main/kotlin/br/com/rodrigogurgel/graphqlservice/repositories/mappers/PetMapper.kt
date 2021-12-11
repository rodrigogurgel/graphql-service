package br.com.rodrigogurgel.graphqlservice.repositories.mappers

import br.com.rodrigogurgel.graphqlservice.models.Pet
import br.com.rodrigogurgel.graphqlservice.models.PetType
import java.sql.ResultSet
import java.util.UUID
import org.springframework.jdbc.core.RowMapper

class PetMapper : RowMapper<Pet> {

    override fun mapRow(rs: ResultSet, rowNum: Int): Pet =
        Pet(
            id = UUID.fromString(rs.getString("id")),
            name = rs.getString("name"),
            type = PetType.getValueOrUnknown(rs.getString("pet_type")),
            userId = UUID.fromString(rs.getString("user_id"))
        )
}