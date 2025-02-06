package com.peakwork.trainee.artem.packagesearch;




public class Offer {


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

    public HotelInfo getHotelInfo() {
        return hotelInfo;
    }

    public void setHotelInfo(HotelInfo hotelInfo) {
        this.hotelInfo = hotelInfo;
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

    long id;
    String flightProvider;
    String departureAirport;
    String arrivalAirport;
    HotelInfo hotelInfo;
    double flightPrice;
    double hotelPrice;
    double totalPrice;

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Offer(long id, String flightProvider, String departureAirport, String arrivalAirport, HotelInfo hotelInfo, double flightPrice, double hotelPrice, double totalPrice) {
        this.id = id;
        this.flightProvider = flightProvider;
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
        this.hotelInfo = hotelInfo;
        this.flightPrice = flightPrice;
        this.hotelPrice = hotelPrice;
        this.totalPrice = totalPrice;
    }

}