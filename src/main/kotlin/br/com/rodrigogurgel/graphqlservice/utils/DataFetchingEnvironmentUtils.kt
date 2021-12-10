package br.com.rodrigogurgel.graphqlservice.utils

import graphql.schema.DataFetchingEnvironment

object DataFetchingEnvironmentUtils {
    fun DataFetchingEnvironment.selectedFields(): List<String> {
        return this.selectionSet.fields.map { it.name }
    }
}