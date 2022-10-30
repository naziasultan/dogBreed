package com.dog.breed.config

import io.r2dbc.spi.ConnectionFactories
import io.r2dbc.spi.ConnectionFactory
import io.r2dbc.spi.ConnectionFactoryOptions.*
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories

@Configuration
@EnableR2dbcRepositories
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

   /* @Bean
    fun transactionManager(connectionFactory: ConnectionFactory): ReactiveTransactionManager? {
        return R2dbcTransactionManager(connectionFactory)
    }*/
}