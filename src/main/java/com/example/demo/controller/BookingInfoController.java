package com.example.demo.controller;


import com.example.demo.entity.AirportStruct;
import com.example.demo.entity.BookinginfoStruct;
import com.example.demo.service.AirportService;
import com.example.demo.service.BookingInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookingInfoController {


    @Autowired
    private BookingInfoService bookingInfoService;


    @PostMapping(value = "/bookingInfo")
    public BookinginfoStruct addBookingInfo(@RequestBody BookinginfoStruct bookinginfoStruct) {
            return this.bookingInfoService.addBooking(bookinginfoStruct);
    }

    @GetMapping(value ="/bookingInfo")
    public List<BookinginfoStruct> findAllBooking()
    {
        return this.bookingInfoService.findAllBooking();
    }

}
