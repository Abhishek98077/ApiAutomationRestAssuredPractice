package org.example.tests.misc.payloadMap;

import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class payloadUsingMap {
    RequestSpecification requestSpecification;
    ValidatableResponse validatableResponse;
    @Test
    public void createUser(){
        String token ="b1cd289b1918611";
//        String payload = "{\n" +
//                "    \"firstname\" :\"Abhishek\",\n" +
//                "    \"lastname\" : \"thakur\",\n" +
//                "    \"totalprice\":100,\n" +
//                "    \"depositpaid\":true,\n" +
//                "    \"additionalneeds\":\"breakfast\",\n" +
//                "    \"bookingdates\":{\n" +
//                "        \"checkin\" :\"2024-09-12\",\n" +
//                "        \"checkout\":\"2024-16-12\"\n" +
//                "    }    \n" +
//                "}";

        Faker faker = new Faker();


        Map<String, Object>jsonBodyUsingMap = new LinkedHashMap<>();
        jsonBodyUsingMap.put("firstname",faker.name().firstName());
        jsonBodyUsingMap.put("lastname",faker.name().lastName());
        jsonBodyUsingMap.put("totalprice",faker.random().nextInt(2000));
        jsonBodyUsingMap.put("depositpaid",faker.random().nextBoolean());

        Map<String ,Object>BookingDateHashMap = new HashMap<>();
        BookingDateHashMap.put("checkin" ,"2024-09-12");
        BookingDateHashMap.put("checkout" ,"2024-09-14");


        jsonBodyUsingMap.put("bookingdates",BookingDateHashMap);
        jsonBodyUsingMap.put("additionalneeds","Dinner");

        System.out.println(jsonBodyUsingMap);


        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
        requestSpecification.basePath("booking/");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(jsonBodyUsingMap).log().all();

        Response response = requestSpecification.when().post();

        validatableResponse = response.then().statusCode(200);
        Integer bookingID = validatableResponse.extract().path("bookingid");
        System.out.println(bookingID);


    }
}
