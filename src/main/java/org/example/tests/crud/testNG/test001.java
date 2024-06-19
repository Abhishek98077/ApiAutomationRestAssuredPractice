package org.example.tests.crud.testNG;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class test001 {


     RequestSpecification requestSpecification;
    ValidatableResponse validatableResponse;
    String token;

@BeforeTest
    public void getToken(){
        requestSpecification = RestAssured.given();
        String payload = payload ="{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";

        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/auth");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(payload).log().all();

        Response response = requestSpecification.post();
        validatableResponse =response.then().log().all();
        validatableResponse.statusCode(200);
        token =response.then().extract().path("token");
        validatableResponse.body("token", Matchers.notNullValue());
        //Matchers TestNG assertion AssertJ
        Assert.assertNotNull(token);



    }
    @Test

    public void testNonBdd(){
    String payload ="{\n" +
            "    \"firstname\" :\"Anshu\",\n" +
            "    \"lastname\" : \"thakur\",\n" +
            "    \"totalprice\":100,\n" +
            "    \"depositpaid\":true,\n" +
            "    \"additionalneeds\":\"breakfast\",\n" +
            "    \"bookingdates\":{\n" +
            "        \"checkin\" :\"2024-09-12\",\n" +
            "        \"checkout\":\"2024-16-12\"\n" +
            "    }    \n" +
            "}";

    requestSpecification.contentType(ContentType.JSON);
    requestSpecification.cookie("token" ,token);
    requestSpecification.baseUri("https://restful-booker.herokuapp.com/booking");
    requestSpecification.basePath("/15");
    requestSpecification.body(payload);

    Response response = requestSpecification.response().when().put();

        System.out.println(response.asString());

        validatableResponse = response.then().log().all();



    }
}
