package com.example.demo.controller;


import com.example.demo.entity.AirportStruct;
import com.example.demo.entity.BookinginfoStruct;
import com.example.demo.service.AirportService;
import com.example.demo.service.BookingInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
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


    @PutMapping(value = "/bookingInfo")
    public BookinginfoStruct updateBookingInfo(@RequestBody BookinginfoStruct bookinginfoStruct) {
        return this.bookingInfoService.addBooking(bookinginfoStruct);
    }

}
