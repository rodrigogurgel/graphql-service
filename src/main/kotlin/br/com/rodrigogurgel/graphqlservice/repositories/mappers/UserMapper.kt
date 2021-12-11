package br.com.rodrigogurgel.graphqlservice.repositories.mappers

import br.com.rodrigogurgel.graphqlservice.models.User
import java.sql.ResultSet
import java.time.OffsetDateTime
import java.time.ZoneOffset
import java.util.UUID
import org.springframework.jdbc.core.RowMapper

class UserMapper : RowMapper<User> {

    override fun mapRow(rs: ResultSet, rowNum: Int): User =
        User(
            id = UUID.fromString(rs.getString("id")),
            name = rs.getString("name"),
        )
}