package com.dog.breed;

import com.dog.breed.model.Dog;

import io.r2dbc.spi.ConnectionFactories;
import io.r2dbc.spi.ConnectionFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;


@SpringBootTest
@AutoConfigureWebTestClient
@ActiveProfiles(profiles = "test")
class DogControllerTest {

  @Autowired
  private WebTestClient webTestClient;

  @Value("${spring.r2dbc.url}")
  private String dbUrl;

  @BeforeEach
  public void setup() {
    initializeDatabase();
  }

  private void initializeDatabase() {
    ConnectionFactory connectionFactory = ConnectionFactories.get(dbUrl);
    R2dbcEntityTemplate template = new R2dbcEntityTemplate(connectionFactory);
    String query = "CREATE TABLE IF NOT EXISTS dog (metadata json default '{}', PRIMARY KEY (id) );";
    template.getDatabaseClient().sql(query).fetch().rowsUpdated().block();
  }

  @Test
  public void getAll() {
    webTestClient.get()
        .uri("/api/breeds/list/all")
        .accept(MediaType.APPLICATION_JSON)
        .exchange()
        .expectStatus()
        .isOk()
        .expectBody()
        .jsonPath("$")
        .isArray();
  }

}
