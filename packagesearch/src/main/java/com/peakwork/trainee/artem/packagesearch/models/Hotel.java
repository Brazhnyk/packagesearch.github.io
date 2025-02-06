package com.peakwork.trainee.artem.packagesearch.models;

import lombok.ToString;
import org.bson.codecs.pojo.annotations.BsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@ToString
@Document("hotel")
public class Hotel {

    @BsonProperty(value = "_id")
    @Id
    private long id;
    private String
            hotelName,
            hotelProvider,
            nextHotelAirport;
    private double price;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getHotelProvider() {
        return hotelProvider;
    }

    public void setHotelProvider(String flightProvider) {
        this.hotelProvider = flightProvider;
    }

    public String getNextHotelAirport() {
        return nextHotelAirport;
    }

    public void setNextHotelAirport(String nextHotelAirport) {
        this.nextHotelAirport = nextHotelAirport;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
