package com.example.demo.service;

import com.example.demo.entity.AirportStruct;
import com.example.demo.entity.BookinginfoStruct;
import com.example.demo.repository.AirportRepository;
import com.example.demo.repository.BookingInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class BookingInfoService {

    @Autowired
    private BookingInfoRepository bookingInfoRepository;

    public BookinginfoStruct addBooking( BookinginfoStruct bookinginfoStruct) {
        return this.bookingInfoRepository.save(bookinginfoStruct);
    }


    public List<BookinginfoStruct> findAllBooking()
    {
        return this.bookingInfoRepository.findAll();
    }

}
