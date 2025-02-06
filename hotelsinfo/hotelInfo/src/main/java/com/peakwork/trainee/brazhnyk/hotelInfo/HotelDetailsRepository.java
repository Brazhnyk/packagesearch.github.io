package com.peakwork.trainee.brazhnyk.hotelInfo;

import com.peakwork.trainee.brazhnyk.hotelInfo.model.HotelDetail;
import org.bson.conversions.Bson;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.ArrayList;

public interface HotelDetailsRepository extends MongoRepository<HotelDetail, String> {


}
