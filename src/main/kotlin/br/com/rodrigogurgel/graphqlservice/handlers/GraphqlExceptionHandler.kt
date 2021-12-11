package br.com.rodrigogurgel.graphqlservice.handlers

import br.com.rodrigogurgel.graphqlservice.exceptions.PetNotFoundException
import br.com.rodrigogurgel.graphqlservice.exceptions.UserNotFoundException
import graphql.GraphQLError
import graphql.kickstart.spring.error.ThrowableGraphQLError
import org.springframework.dao.DuplicateKeyException
import org.springframework.web.bind.annotation.ExceptionHandler

class GraphqlExceptionHandler {
    @ExceptionHandler(DuplicateKeyException::class)
    fun duplicateKeyExceptionHandler(exception: DuplicateKeyException): GraphQLError {
        return ThrowableGraphQLError(exception, exception.message)
    }

    @ExceptionHandler(UserNotFoundException::class)
    fun userNotFoundExceptionHandler(userNotFoundException: UserNotFoundException) : GraphQLError{
        return ThrowableGraphQLError(userNotFoundException, userNotFoundException.message)
    }

    @ExceptionHandler(PetNotFoundException::class)
    fun userNotFoundExceptionHandler(petNotFoundException: PetNotFoundException) : GraphQLError{
        return ThrowableGraphQLError(petNotFoundException, petNotFoundException.message)
    }
}