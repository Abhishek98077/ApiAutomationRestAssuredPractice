package org.example.tests.crud.POST;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class createBooking {
            RequestSpecification requestSpecifation;
            ValidatableResponse validtableResponse;
@Test
    public void createUser(){
        String token ="8c47ad4deb1d284";
        String payload = "{\n" +
                "    \"firstname\" :\"Abhishek\",\n" +
                "    \"lastname\" : \"thakur\",\n" +
                "    \"totalprice\":100,\n" +
                "    \"depositpaid\":true,\n" +
                "    \"additionalneeds\":\"breakfast\",\n" +
                "    \"bookingdates\":{\n" +
                "        \"checkin\" :\"2024-09-12\",\n" +
                "        \"checkout\":\"2024-16-12\"\n" +
                "    }    \n" +
                "}";
        requestSpecifation = RestAssured.given();
        requestSpecifation.baseUri("https://restful-booker.herokuapp.com/");
        requestSpecifation.basePath("booking/");
        requestSpecifation.contentType(ContentType.JSON);
        requestSpecifation.body(payload);

        Response response = requestSpecifation.post();
        validtableResponse = response.then().statusCode(200);
        Integer bookindId = response.then().extract().path("bookingid");
        System.out.println(bookindId);

    }
}
