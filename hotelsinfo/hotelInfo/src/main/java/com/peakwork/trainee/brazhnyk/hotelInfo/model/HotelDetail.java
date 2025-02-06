package com.peakwork.trainee.brazhnyk.hotelInfo.model;

import lombok.ToString;
import org.bson.codecs.pojo.annotations.BsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@ToString
@Document("hotel_details")
public class HotelDetail {
    @BsonProperty(value = "_id")
    @Id
    private long id;
    private String
            hotelName,
            slogan,
            hotelImageUrl;

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

    public HotelDetail() {

    }

    public HotelDetail(int id, String hotelName, String slogan, String hotelImageUrl) {
        this.id = id;
        this.hotelName = hotelName;
        this.slogan = slogan;
        this.hotelImageUrl = hotelImageUrl;
    }
}

