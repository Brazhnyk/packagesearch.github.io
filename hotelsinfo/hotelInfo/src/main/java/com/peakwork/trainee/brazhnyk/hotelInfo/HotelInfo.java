package com.peakwork.trainee.brazhnyk.hotelInfo;

import com.mongodb.*;
import com.mongodb.client.*;
import com.mongodb.client.MongoClient;
import com.peakwork.trainee.brazhnyk.hotelInfo.model.HotelDetail;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.*;
import java.util.regex.Pattern;


@RestController
public class HotelInfo {

    @Value("${spring.data.mongodb.uri}")
    private String mongoUri;
    private final HotelDetailsRepository hotelDetailsRepository;
    final private Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");

    public HotelInfo(HotelDetailsRepository hotelDetailsRepository) {
        this.hotelDetailsRepository = hotelDetailsRepository;
    }

    public boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        return pattern.matcher(strNum).matches();
    }

    @GetMapping("/hotels")
    public ArrayList<HotelDetail> giveHotelsDetailInfo(@RequestParam(value = "id", required = false) String id) {
        List<HotelDetail> hotelsList = this.hotelDetailsRepository.findAll();
        ArrayList<HotelDetail> hotel = new ArrayList<>();

        try {

            if (id.isEmpty())
                throw new NumberFormatException("Id can´t be empty, please enter data");

            if (!isNumeric(id))
                throw new NumberFormatException("Please enter id number");

            if (Long.parseLong(id) < 0)
                throw new RuntimeException("Id can´t be Null or negative");
            Long.parseLong(id);

            for (HotelDetail hotelValue : hotelsList) {
                if (Long.toString(hotelValue.getId()).equals((id))) {
                    hotel.add(hotelValue);
                }
            }

            if (hotelsList.isEmpty() || hotel.isEmpty()) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not find any information");
            }
        } catch (Exception exc) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, exc.getMessage());
        }

        return hotel;
    }
}
