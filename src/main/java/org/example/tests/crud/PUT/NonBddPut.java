package org.example.tests.crud.PUT;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class NonBddPut {

    @Test

    public void testPutRequest(){

        String token = "433a24437fd5186";
        String payload = "{\n" +
                "            \"firstname\" :\"rishu\",\n" +
                "            \"lastname\" : \"thakur\",\n" +
                "            \"totalprice\":1000,\n" +
                "            \"depositpaid\":true,\n" +
                "            \"additionalneeds\":\"lunch\",\n" +
                "            \"bookingdates\":{\n" +
                "                \"checkin\" :\"2024-09-12\",\n" +
                "                \"checkout\":\"2024-16-12\"\n" +
                "            }\n" +
                "        }";
        RequestSpecification r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com/");
        r.basePath("booking/1634");
        r.contentType(ContentType.JSON);

        r.cookie("token",token);
        r.body(payload).log().all();


        Response response = r.response().when().put();

        //Get Validable response to perform validation
        ValidatableResponse validatableResponse =response.then().log().all();
        validatableResponse.statusCode(200);
        validatableResponse.body("firstname" , Matchers.equalTo("rishu"));
        validatableResponse.body("lastname" , Matchers.equalTo("thakur"));


    }
}
