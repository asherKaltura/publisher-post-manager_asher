package com.api;

import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.*;

public class ApiTest {

    @Test
    void testGetPosts() {
        RestAssured.given()
                .baseUri("http://localhost:8080")
                .when().get("/api/posts")
                .then()
                .statusCode(200)
                .body("size()", greaterThanOrEqualTo(0));
    }

    @Test
    void testCreatePost() {
        RestAssured.given()
                .baseUri("http://localhost:8080")
                .contentType("application/json")
                .body("{\"title\":\"Test\",\"content\":\"Content\"}")
                .when().post("/api/posts")
                .then()
                .statusCode(200)
                .body("title", equalTo("Test"));
    }
}