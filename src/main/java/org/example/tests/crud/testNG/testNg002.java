package org.example.tests.crud.testNG;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;

public class testNg002 {

    private RequestSpecification requestSpecification;
    private ValidatableResponse validatableResponse;
    private String token;
    private Integer bookingId;

    @BeforeMethod
    public void setUp() {
        System.out.println("Setting up test environment:");
        String payload = "{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";

        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/auth");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(payload);

        // Generating token
        Response response = requestSpecification.post();
        token = response.then().log().all().extract().path("token");
        assertThat(token, Matchers.notNullValue());
        System.out.println("Token generated: " + token);
    }

    @BeforeMethod(dependsOnMethods = "setUp")
    public void createBooking() {
        System.out.println("Creating booking:");
        if (token == null) {
            System.out.println("Token is null. Aborting createBooking.");
            return; // Abort if token is null
        }

        String payload = "{\n" +
                "    \"firstname\" :\"Abhishek\",\n" +
                "    \"lastname\" : \"Malini\",\n" +
                "    \"totalprice\":20000,\n" +
                "    \"depositpaid\":true,\n" +
                "    \"additionalneeds\":\"breakfast\",\n" +
                "    \"bookingdates\":{\n" +
                "        \"checkin\" :\"2024-09-12\",\n" +
                "        \"checkout\":\"2024-16-12\"\n" +
                "    }\n" +
                "}";

        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.cookie("token", token);

        Response response = requestSpecification. when().post();
        validatableResponse = response.then().log().all().statusCode(Matchers.is(200)); // Assert status code
        bookingId = response.then().extract().path("bookingid");
        System.out.println("Booking ID: " + bookingId);
    }

    @Test
    public void testSomething() {
        // Your test code here
    }
}
