package org.example.tests.crud.POST;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class NonBddStylePost {

    @Test
    public void nonBddStylePostPositive() {
        String payload = payload ="{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";
        RequestSpecification r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/auth");
        r.contentType(ContentType.JSON);
        r.body(payload);

        Response response = r.when().post();
        ValidatableResponse validatableResponse = response.then();
        String responseString =response.asString();
        validatableResponse.statusCode(200).log().all();
        r.then().statusCode(200);

    }
}
