package com.peakwork.trainee.artem.packagesearch;

public class HotelInfo {

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

    public String getSlogan() {
        return slogan;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }

    public String getHotelImageUrl() {
        return hotelImageUrl;
    }

    public void setHotelImageUrl(String hotelImageUrl) {
        this.hotelImageUrl = hotelImageUrl;
    }

    long id;
    String hotelName;
    String slogan;
    String hotelImageUrl;

    public HotelInfo() {

    }

    public HotelInfo(long id, String hotelName, String slogan, String hotelImageUrl) {
        this.id = id;
        this.hotelName = hotelName;
        this.slogan = slogan;
        this.hotelImageUrl = hotelImageUrl;
    }
}

