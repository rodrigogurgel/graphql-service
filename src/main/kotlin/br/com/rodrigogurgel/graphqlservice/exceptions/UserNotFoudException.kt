package br.com.rodrigogurgel.graphqlservice.exceptions

class UserNotFoundException(override val message: String?): RuntimeException() {
}