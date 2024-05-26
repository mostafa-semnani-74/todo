package ir.mostafa.semnani.todo.controller;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import ir.mostafa.semnani.todo.entity.Todo;
import ir.mostafa.semnani.todo.repository.TodoRepository;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasSize;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TodoControllerTest {
    @LocalServerPort
    private Integer port;

    @Autowired
    TodoRepository todoRepository;

    static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>(
            "postgres:15-alpine"
    );

    @BeforeAll
    static void beforeAll() {
        postgres.start();
    }

    @AfterAll
    static void afterAll() {
        postgres.stop();
    }

    @BeforeEach
    void setUp() {
        RestAssured.baseURI = "http://localhost:" + port;
        todoRepository.deleteAll();
    }

    @DynamicPropertySource
    static void configureProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", postgres::getJdbcUrl);
        registry.add("spring.datasource.username", postgres::getUsername);
        registry.add("spring.datasource.password", postgres::getPassword);
    }

    @Test
    void shouldGetAllTodos() {
        List<Todo> todos = List.of(
                new Todo(null, 1, "my first todo", false, null),
                new Todo(null, 2, "my second todo", true, null)
        );
        todoRepository.saveAll(todos);

        given()
                .contentType(ContentType.JSON)
                .when()
                .get("/api/v1/todos")
                .then()
                .statusCode(200)
                .body(".", hasSize(2));
    }

}
