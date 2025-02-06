package com.peakwork.trainee.artem.packagesearch;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;

@Component

public class SourceHotelInfo implements HotelInfoSource {
    @Value("${source.hotelinfo}")
    private String sourceHotelInfo;

    public List<HotelInfo> getQueryHotelInfoViaURL(long id) {
        RestTemplate restTemplate = new RestTemplate();
        String url = sourceHotelInfo + id;
        try {
            HotelInfo[] hotelInfoArray = restTemplate.getForObject(new URI(url), HotelInfo[].class);
            return Arrays.asList(hotelInfoArray);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}
