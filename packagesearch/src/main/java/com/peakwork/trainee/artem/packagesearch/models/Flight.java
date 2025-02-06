package com.peakwork.trainee.artem.packagesearch.models;



import org.springframework.data.mongodb.core.mapping.Document;

import lombok.ToString;
import org.bson.codecs.pojo.annotations.BsonProperty;
import org.springframework.data.annotation.Id;


@ToString
@Document("flight")
public class Flight {
    @BsonProperty(value = "_id")
    @Id
    private long id;

    private String
            flightProvider,
            departureAirport,
            arrivalAirport;
    private double price;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFlightProvider() {
        return flightProvider;
    }

    public void setFlightProvider(String flightProvider) {
        this.flightProvider = flightProvider;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    public void setDepartureAirport(String departureAirport) {
        this.departureAirport = departureAirport;
    }

    public String getArrivalAirport() {
        return arrivalAirport;
    }

    public void setArrivalAirport(String arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
