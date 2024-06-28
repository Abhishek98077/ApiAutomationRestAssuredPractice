package org.example.tests;

import io.restassured.RestAssured;

public class jsonSchemaDemo {
    public static void main(String[] args) {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com/posts/1";
        RestAssured.given().when().get();


    }
}
