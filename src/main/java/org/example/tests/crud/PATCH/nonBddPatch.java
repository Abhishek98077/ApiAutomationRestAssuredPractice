package org.example.tests.crud.PATCH;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class nonBddPatch {
    @Test
    public void testPatch() {
        String payload ="{\n" +
                "    \"firstname\": \"rishu\",\n" +
                "    \"lastname\": \"ikajau\",\n" +
                "}";
        String token = "433a24437fd5186";
        
        RequestSpecification r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com/");
        r.basePath("booking/1634");
        r.contentType(ContentType.JSON);
        r.cookie(token ,"token");
        r.body(payload).log().all();

        Response response = r.response().when().patch();

        ValidatableResponse validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);
        validatableResponse.body("firstname", Matchers.equalTo("Rishu"));
        validatableResponse.body("firstname", Matchers.equalTo("unitata"));

    }
}
