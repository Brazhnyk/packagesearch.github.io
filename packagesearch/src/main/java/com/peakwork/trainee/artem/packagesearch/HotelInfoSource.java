package com.peakwork.trainee.artem.packagesearch;

import java.util.List;

public interface HotelInfoSource {

    List<HotelInfo> getQueryHotelInfoViaURL(long id);

}
