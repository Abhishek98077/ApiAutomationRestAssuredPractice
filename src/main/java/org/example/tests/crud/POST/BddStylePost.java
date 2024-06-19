package org.example.tests.crud.POST;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class BddStylePost {

    @Test
    public void positiveTestCase(){
        String token ="8c47ad4deb1d284";
       String payload ="{\n" +
               "    \"username\" : \"admin\",\n" +
               "    \"password\" : \"password123\"\n" +
               "}";

        RestAssured.given()
                .baseUri("https://restful-booker.herokuapp.com")
                .basePath("/auth")
                .contentType(ContentType.JSON)

                .body(payload)
                .when()
                .post()
                .then().log().all()
                .statusCode(200);
    }
}
