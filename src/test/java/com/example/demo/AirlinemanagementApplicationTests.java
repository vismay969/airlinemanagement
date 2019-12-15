package com.example.demo;

import com.example.demo.controller.AirportController;
import com.example.demo.controller.BookingInfoController;
import com.example.demo.controller.FlightMasterController;
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
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
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
    public void testPostairportController  () throws Exception
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
/*
      .andExpect(status().isCreated())
*/
            .andExpect(MockMvcResultMatchers.jsonPath("$.location_abbr").exists());

      //  this.mockMvc.perform(post("/airport?" + airportStruct)).andDo(print()).andExpect(status().isOk());
    }
/*

     @Test
     public void testPostFlightMasterController() throws Exception
     {
         List<FlightDetailStruct> flightDetailStruct = (List<FlightDetailStruct>) new FlightDetailStruct();
         FlightMasterStruct flightMasterStruct = new FlightMasterStruct(
            0,
            "Air India",
            "MUM",
            "ADI",
            20,
            20,
            flightDetailStruct
         );
         System.out.println(flightMasterStruct);
         this.mockMvc.perform(post("/flightMaster  " + flightMasterStruct)).andDo(print()).andExpect(status().isOk());
     }
*/
/*

     @Test
     public void testAddBookingInfoController() throws Exception
     {
         LocalDateTime deptDate=  LocalDateTime.now();
         FlightDetailStruct flightDetailStruct = new FlightDetailStruct();
         UserDetailsStruct userDetailsStruct = new UserDetailsStruct();
         BookinginfoStruct bookinginfoStruct=
                new BookinginfoStruct(
                0,
                deptDate,
                "mehernoshp@yahoo.com",
                1,
                "Business",
                10550.75,
                3,
                "123123123",
                "N",
                flightDetailStruct,
                userDetailsStruct);

         this.mockMvc.perform(post("/bookingInfo/1/15 " + bookinginfoStruct)).andDo(print()).andExpect(status().isOk());
         //  (value = "/bookingInfo/{userId}/{flight_sch_no}")

     }
*/

    @Test
    public void testFlightMasterController() throws Exception
    {
        assertThat(flightMasterController).isNotNull();
    }


    @Test
    void contextLoads() {
    }

}
