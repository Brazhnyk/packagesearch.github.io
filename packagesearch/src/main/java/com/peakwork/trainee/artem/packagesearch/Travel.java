package com.peakwork.trainee.artem.packagesearch;

public class Travel {


    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public double getFlightPrice() {
        return flightPrice;
    }

    public void setFlightPrice(double flightPrice) {
        this.flightPrice = flightPrice;
    }

    public double getHotelPrice() {
        return hotelPrice;
    }

    public void setHotelPrice(double hotelPrice) {
        this.hotelPrice = hotelPrice;
    }

    int id;
    String flightProvider;
    String departureAirport;
    String arrivalAirport;
    String hotelName;
    double flightPrice;
    double hotelPrice;
    int counter = 0;

    public Travel() {
        counter++;
    }

    public Travel(int id, String flightProvider, String departureAirport, String arrivalAirport, String hotelName, double flightPrice, double hotelPrice) {
        this.id = id;
        this.flightProvider = flightProvider;
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
        this.hotelName = hotelName;
        this.flightPrice = flightPrice;
        this.hotelPrice = hotelPrice;
    }
}
