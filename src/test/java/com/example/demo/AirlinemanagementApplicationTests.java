package com.example.demo;

import com.example.demo.controller.AirportController;
import com.example.demo.controller.BookingInfoController;
import com.example.demo.controller.FlightMasterController;
import com.example.demo.datamapping.SearchFlightStruct;
import com.example.demo.entity.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc

class AirlinemanagementApplicationTests {

    @Autowired
    private BookingInfoController bookingInfoController;

    @Autowired
    private FlightMasterController flightMasterController;

    @Autowired
    private AirportController airportController;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testBookingInfoController() throws Exception
    {
        assertThat(bookingInfoController).isNotNull();
    }

    @Test
    public void testGetFlightMasterController() throws Exception
    {
        this.mockMvc.perform(get("/flightMaster")).andDo(print()).andExpect(status().isOk());
     }


    @Test
    public void testFlightMasterController() throws Exception
    {
        assertThat(flightMasterController).isNotNull();
    }

    @Test
     public void testGetBookingInfoController() throws Exception
     {
         this.mockMvc.perform(get("/bookingInfo")).andDo(print()).andExpect(status().isOk());
         }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testShouldAddNewAirportPostairportController  () throws Exception
    {
        AirportStruct airportStruct = new AirportStruct(
        0,
        "T2-Mumbai",
        "MUM-T2",
        "Mumbai"
        );
        System.out.println(airportStruct);
        this.mockMvc.perform(MockMvcRequestBuilders
                .post("/airport")
                .content(asJsonString(airportStruct))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.location_abbr").exists());

    }

    @Test
    public void testGetShouldReturnAllFlightDetailsFlightMasterController() throws Exception
    {
        this.mockMvc.perform(MockMvcRequestBuilders
                .get("/flightDetail")
                .accept(MediaType.APPLICATION_JSON) )
                .andDo(print())
            .andExpect(status().isOk()) ;
    }

    @Test
    public void testGetShouldReturnListOfFlightsFlightMasterController() throws Exception
    {


        this.mockMvc.perform( MockMvcRequestBuilders
                .get("/flightMaster/1/0/ADI/MUM/2019-12-31")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())

                .andExpect(status().isOk());
    }

}
