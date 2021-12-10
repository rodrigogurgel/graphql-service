package br.com.rodrigogurgel.graphqlservice.repositories.mappers

import java.sql.ResultSet
import java.time.OffsetDateTime
import java.time.ZoneOffset
import java.util.UUID

abstract class BaseMapper(private val selectedFields: List<String>) {
    protected fun getUUID(rs: ResultSet, name: String): UUID? {
        return if (selectedFields.contains(name)) {
            UUID.fromString(rs.getString(name))
        } else {
            null
        }
    }

    protected fun getString(rs: ResultSet, name: String): String? {
        return if (selectedFields.contains(name)) {
            rs.getString(name)
        } else {
            null
        }
    }

    protected fun getOffsetDateTime(rs: ResultSet, name: String): OffsetDateTime? {
        return if (selectedFields.contains(name)) {
            OffsetDateTime.of(rs.getTimestamp(name).toLocalDateTime(), ZoneOffset.ofHours(-3))
        } else {
            null
        }
    }
}