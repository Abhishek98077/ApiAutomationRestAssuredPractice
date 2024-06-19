package org.example.tests.crud.GET;

import io.restassured.RestAssured;

public class RAtestCase {
    public static void main(String[] args) {
        RestAssured.given().baseUri("https://api.zippopotam.us").basePath("IN/175024").when().get().then().statusCode(200);

    }
}
