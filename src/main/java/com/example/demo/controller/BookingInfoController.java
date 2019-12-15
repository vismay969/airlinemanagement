package com.example.demo.controller;


import com.example.demo.entity.AirportStruct;
import com.example.demo.entity.BookinginfoStruct;
import com.example.demo.service.AirportService;
import com.example.demo.service.BookingInfoService;
import com.example.demo.util.Mailer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
public class BookingInfoController {


    @Autowired
    private BookingInfoService bookingInfoService;

    @Autowired
    private Mailer mail;


    @PostMapping(value = "/bookingInfo/{userId}/{flight_sch_no}")
    public BookinginfoStruct addBookingInfo(@RequestBody BookinginfoStruct bookinginfoStruct, @PathVariable("userId") Integer userId, @PathVariable("flight_sch_no") Integer flight_sch_no) {

        String email = bookinginfoStruct.getCust_email();
        //LocalDate iternaryDate = bookinginfoStruct.getFlight_date();
        mail.sendMail(email);

        return this.bookingInfoService.addBookingDetail(flight_sch_no, userId, bookinginfoStruct);
    }

    @GetMapping(value ="/bookingInfo")
    public List<BookinginfoStruct> findAllBooking()
    {
        return this.bookingInfoService.findAllBooking();
    }


    @PutMapping(value = "/bookingInfo/{userId}/{flight_sch_no}")
    public BookinginfoStruct updateBookingInfo(@RequestBody BookinginfoStruct bookinginfoStruct,  @PathVariable("userId") Integer userId, @PathVariable("flight_sch_no") Integer flight_sch_no) {
        return this.bookingInfoService.addBookingDetail(flight_sch_no, userId, bookinginfoStruct);
    }

    @GetMapping(value ="/bookingInfo/{userId}")
    public List<BookinginfoStruct> findBookingByUserIdAndDate(@PathVariable("userId") Integer userId)
    {
        LocalDateTime lDate = LocalDateTime.now();
        return this.bookingInfoService.findByUserIdandCurrentDate(userId, lDate);
    }
    @PutMapping(value = "/bookingInfo")
    public BookinginfoStruct softDeleteBookingId(@RequestBody BookinginfoStruct bookinginfoStruct) {
        return this.bookingInfoService.softDeleteBookingId(bookinginfoStruct);

    }



}
