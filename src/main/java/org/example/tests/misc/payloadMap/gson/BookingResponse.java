package org.example.tests.misc.payloadMap.gson;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BookingResponse {

    @SerializedName("bookingid")
    @Expose
    private Integer bookingid;
    @SerializedName("booking")
    @Expose
    private Gsondemo Gsondemo;

    public Integer getBookingid() {
        return bookingid;
    }

    public void setBookingid(Integer bookingid) {
        this.bookingid = bookingid;
    }

    public Gsondemo getBooking() {
        return Gsondemo;
    }

    public void setBooking(Gsondemo Gsondemo) {
        this.Gsondemo = Gsondemo;
    }

}