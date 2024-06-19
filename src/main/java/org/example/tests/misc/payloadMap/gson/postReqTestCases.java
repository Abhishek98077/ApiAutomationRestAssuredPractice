package org.example.tests.misc.payloadMap.gson;

import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class postReqTestCases {
    RequestSpecification requestSpecification;
    ValidatableResponse validatableResponse;

    @Test

    public void positiveTestCase() {

        Gsondemo booking = new Gsondemo();
        booking.setFirstname("Shantaniu");
        booking.setLastname("Raju");
        booking.setTotalprice(5000);
        booking.setDepositpaid(true);

        Bookingdates bookingdates = new Bookingdates();
        bookingdates.setCheckin("2024-8-15");
        bookingdates.setCheckout("2024-8-19");
        booking.setBookingdates(bookingdates);
        booking.setAdditionalneeds("lunch");

        Gson gson = new Gson();
        String jsonStringOfBookind = gson.toJson(booking);



        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
        requestSpecification.basePath("booking/");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(booking).log().all();

        Response response = requestSpecification.when().post();
        String jsonResponseString = response.asString();

        BookingResponse bookingResponseObject = gson.fromJson(jsonResponseString ,BookingResponse.class);



        Assert.assertNotNull(bookingResponseObject.getBookingid());
        Assert.assertNotNull(bookingResponseObject.getBooking().getLastname());
        Assert.assertEquals(bookingResponseObject.getBooking().getAdditionalneeds(),"lunch");

        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);
    }
}
