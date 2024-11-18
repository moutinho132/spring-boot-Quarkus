package com.example;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.*;

@QuarkusTest
public class TaskResourceTest {

    @Test
    public void testGetAllTasks() {
        RestAssured.given()
                .when().get("/tasks")
                .then()
                .statusCode(200)
                .body(is("[]"));
    }

    @Test
    public void testCreateTask() {
        RestAssured.given()
                .contentType("application/json")
                .body("{\"title\":\"Test Task\",\"description\":\"Testing Quarkus\",\"completed\":false}")
                .when().post("/tasks")
                .then()
                .statusCode(200)
                .body("title", is("Test Task"));
    }
}