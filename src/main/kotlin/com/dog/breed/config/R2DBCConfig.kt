package com.dog.breed.config

import io.r2dbc.spi.ConnectionFactories
import io.r2dbc.spi.ConnectionFactory
import io.r2dbc.spi.ConnectionFactoryOptions.*
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories

/**
 * FIXME: you don't need this config, please remove.
 * FIXME: Connection factory is auto-configured by spring when you enable auto-configuration by using @EnableR2dbcRepositories
 * FIXME: and specifying db connection strings in application.properties
 */
@Configuration
@EnableR2dbcRepositories //FIXME: You need only this annotation
class R2DBCConfig : AbstractR2dbcConfiguration() {
    @Bean
    override fun connectionFactory(): ConnectionFactory {
        return ConnectionFactories.get(
            builder()
                .option(DRIVER, "postgresql")
                .option(HOST, "localhost")
                .option(USER, "user")
                .option(PASSWORD, "password")
                .option(DATABASE, "Dog")
                .build()
        )
    }

    //FIXME: please remove commented code

   /* @Bean
    fun transactionManager(connectionFactory: ConnectionFactory): ReactiveTransactionManager? {
        return R2dbcTransactionManager(connectionFactory)
    }*/
}