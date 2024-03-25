package com.example;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

@QuarkusTest
class ExampleResourceTest {

  @Test
  void testHelloEndpoint() {
    given()
        .when().get("/user/1")
        .then()
        .statusCode(200)
        .body("name", equalTo("Alice")).extract().response();
  }
}