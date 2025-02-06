package com.peakwork.trainee.brazhnyk.hotelInfo;

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
//@TestPropertySource(properties = "spring.datasource.url = jdbc:mongodb://localhost:2717/Brabooking")
@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
class HotelInfoTest {

    @Autowired
    MockMvc mvc;

    @Test
    void travelsCoastTestWithAllParameter() throws Exception {
        mvc.perform(get("/hotels?id=2")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void travelsCoastTestWithoutParameter() throws Exception {
        mvc.perform(get("/hotels?id=")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is(400))
                .andExpect(result -> result.getResolvedException().getMessage().equals("Id can´t be empty, please enter data"));
    }

    @Test
    void travelsCoastTestWithNegativeParameter() throws Exception {
        mvc.perform(get("/hotels?id=-1")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is(400))
                .andExpect(result -> result.getResolvedException().getMessage().equals("Id can´t be Null or negative"));
    }

    @Test
    void travelsCoastTestWithLettersParameter() throws Exception {
        mvc.perform(get("/hotels?id=two")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is(400))
                .andExpect(result -> result.getResolvedException().getMessage().equals("Please enter id number"));
    }


}