package br.com.rodrigogurgel.graphqlservice.configuration

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import javax.sql.DataSource
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.jdbc.core.simple.SimpleJdbcInsert

@Configuration
class DataSourceConfiguration {
    @Bean
    fun hikariConfig(
        @Value("\${spring.datasource.url}") url: String,
        @Value("\${spring.datasource.username}") username: String,
        @Value("\${spring.datasource.password}") password: String,
        @Value("\${spring.datasource.hikari.maximum-pool-size:6}") maximumPoolSize: Int,
        @Value("\${spring.datasource.hikari.leak-detection-threshold:30000}") leakDetectionThreshold: Long,
        @Value("\${spring.datasource.connection-timeout:5000}") connectionTimeout: Long,
    ): HikariConfig {
        val hikariConfig = HikariConfig()

        hikariConfig.jdbcUrl = url
        hikariConfig.username = username
        hikariConfig.password = password
        hikariConfig.maximumPoolSize = maximumPoolSize
        hikariConfig.leakDetectionThreshold = leakDetectionThreshold
        hikariConfig.connectionTimeout = connectionTimeout

        return hikariConfig
    }


    @Bean
    fun dataSource(hikariConfig: HikariConfig): DataSource =
        HikariDataSource(hikariConfig)

    @Bean
    fun namedParameterJdbcTemplate(dataSource: DataSource): NamedParameterJdbcTemplate = NamedParameterJdbcTemplate(dataSource)
}