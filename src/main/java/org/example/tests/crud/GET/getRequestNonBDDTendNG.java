package org.example.tests.crud.GET;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class getRequestNonBDDTendNG {

    @Test
    public void testGetAllBookingPositive() {
        RequestSpecification r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking/1");
        r.when()
                .get()  // Send the GET request
                .then()
                .log().all()
                .statusCode(200);  // Assuming 200 is the correct status code for a successful booking retrieval
    }

    @Test
    public void testGetAllBookingNegative() {
        RequestSpecification r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking/44");
        r.when()
                .get()  // Send the GET request
                .then()
                .log().all()
                .statusCode(200);  // 404 is typically expected for a non-existent resource
    }

    @Test
    public void testGetAllBookingNegative2() {
        RequestSpecification r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking/nv");
        r.when()
                .get()  // Send the GET request
                .then()
                .log().all()
                .statusCode(400);  // 400 is a typical status code for a bad request due to invalid input
    }
}
