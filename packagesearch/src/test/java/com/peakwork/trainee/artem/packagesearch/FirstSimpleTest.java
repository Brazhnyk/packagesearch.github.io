package com.peakwork.trainee.artem.packagesearch;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@RunWith(SpringRunner.class)
@TestPropertySource(properties = "my.sql.address = jdbc:mysql://localhost:3307/Brabooking")
@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
class FirstSimpleTest {

    @Autowired
    MockMvc mvc;

    @MockBean
    HotelInfoSource hotelInfoSource;

    @BeforeEach
    void setup() {
        List<HotelInfo> hotelinfo = new ArrayList<>();
        hotelinfo.add(new HotelInfo( 2, "adasdasd", "asdasdsa", "adasd"));
        when(hotelInfoSource.getQueryHotelInfoViaURL(anyLong())).thenReturn(hotelinfo);
    }

    @Test
    void travelsCoastTestWithAllParameter() throws Exception {
        mvc.perform(get("/offers?arrival=LWO&persons=2&los=2")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void travelsCoastArrivalFail() throws Exception {


        mvc.perform(get("/offers?arrival=&persons=3&los=2")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is(400))
                .andExpect(result -> result.getResolvedException().getMessage().equals("Must be three Letters"));


        mvc.perform(get("/offers?arrival=lwo&persons=3&los=2")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200));

    }

    @Test
    void travelsCoastPersonFail() throws Exception {

        mvc.perform(get("/offers?arrival=LWO&persons=&los=2")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is(400))
                .andExpect(result -> result.getResolvedException().getMessage().equals("Persons can´t be empty, please enter data"));

        mvc.perform(get("/offers?arrival=LWO&persons=-1&los=2")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is(400))
                .andExpect(result -> result.getResolvedException().getMessage().equals("One or more person must travel"));


        mvc.perform(get("/offers?arrival=LWO&persons=0&los=2")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is(400))
                .andExpect(result -> result.getResolvedException().getMessage().equals("One or more person must travel"));
    }

    @Test
    void travelCoastNightsFail() throws Exception {
        mvc.perform(get("/offers?arrival=LWO&persons=3&los=")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is(400))
                .andExpect(result -> result.getResolvedException().getMessage().equals("Nights can´t be empty, please enter data"));

        mvc.perform(get("/offers?arrival=LWO&persons=&los=-1")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is(400))
                .andExpect(result -> result.getResolvedException().getMessage().equals("Must be at least one night"));


        mvc.perform(get("/offers?arrival=LWO&persons=&los=0")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is(400))
                .andExpect(result -> result.getResolvedException().getMessage().equals("Must be at least one night"));
    }

}

