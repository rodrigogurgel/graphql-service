# Kotlin Graphql Service

This repository is an example of a graphql service with kotlin

### What was used in this repository

* [graphql-java-kickstart](https://www.graphql-java-kickstart.com) to provide a graphql service

```kotlin-dsl
// graphql dependecies version 11.1.0
implementation("com.graphql-java-kickstart:graphql-spring-boot-starter:$graphqlJavaKickstartVersion")
implementation("com.graphql-java-kickstart:graphiql-spring-boot-starter:$graphqlJavaKickstartVersion")
implementation("com.graphql-java-kickstart:voyager-spring-boot-starter:$graphqlJavaKickstartVersion")
implementation("com.graphql-java-kickstart:playground-spring-boot-starter:$graphqlJavaKickstartVersion")
  ```

* Java Database Connectivity (JDBC) to access database

```kotlin-dsl
// JDBC
implementation("org.springframework.boot:spring-boot-starter-jdbc:$springframeworkBootVersion")
```

* HikariCP to connection pool

```koltin-dsl
// HikariCP
implementation("com.zaxxer:HikariCP:5.0.0")
```

* PostgreSQL Driver to drive JDBC access

```kotlin-dsl
// Postgresql Driver
implementation("org.postgresql:postgresql:42.3.1")
```

* Docker to create Postgres Database instance

## How to run it

Run it in the terminal inside your project folder

```bash/cmd
docker build -t "graphql-service-db" db/
docker run -d -p 5432:5432 graphql-service-db
```

Run GraphqlServiceApplication in your IDE

## Schema explanation

![explanation](explanation.drawio.png)

## What is Graphql

### A query language for your API

GraphQL is a query language for APIs and a runtime for fulfilling those queries with your existing data. GraphQL
provides a complete and understandable description of the data in your API, gives clients the power to ask for exactly
what they need and nothing more, makes it easier to evolve APIs over time, and enables powerful developer tools.

For more details about
graphql [click here](https://www.youtube.com/watch?v=EZdxsUF_5LM&list=RDCMUCcMcmtNSSQECjKsJA1XH5MQ&start_radio=1&rv=EZdxsUF_5LM&t=6&ab_channel=Cod3rCursos)

## Kotlin/Java Graphql

This repository uses [graphql-java-kickstart](https://www.graphql-java-kickstart.com) to provide graphql api, but it has
another dependencies.

### Useful links

* [schema-definition](https://www.graphql-java-kickstart.com/tools/schema-definition/)
* [extended-scalars](https://github.com/graphql-java-kickstart/graphql-spring-boot#extended-scalars)
* [pagination](https://www.youtube.com/watch?v=J9Nq0Fq7t_8&ab_channel=PhilipStarritt)
* [Spring Boot GraphQL Tutorial - Full Course](https://www.youtube.com/watch?v=nju6jFW8CVw&list=PLiwhu8iLxKwL1TU0RMM6z7TtkyW-3-5Wi&ab_channel=PhilipStarritt)
