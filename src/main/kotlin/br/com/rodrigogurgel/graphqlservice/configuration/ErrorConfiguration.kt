package br.com.rodrigogurgel.graphqlservice.configuration

import br.com.rodrigogurgel.graphqlservice.handlers.GraphqlExceptionHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ErrorConfiguration() {

    @Bean
    fun customErrorHandler() = GraphqlExceptionHandler()

}