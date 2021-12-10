package br.com.rodrigogurgel.graphqlservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class GraphqlServiceApplication

fun main(args: Array<String>) {
	runApplication<GraphqlServiceApplication>(*args)
}
