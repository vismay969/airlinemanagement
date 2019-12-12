package com.example.demo.service;

import com.example.demo.entity.AirportStruct;
import com.example.demo.entity.BookinginfoStruct;
import com.example.demo.entity.FlightDetailStruct;
import com.example.demo.entity.UserDetailsStruct;
import com.example.demo.repository.AirportRepository;
import com.example.demo.repository.BookingInfoRepository;
import com.example.demo.repository.FlightDetailRepository;
import com.example.demo.repository.UserDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class BookingInfoService {

    @Autowired
    private BookingInfoRepository bookingInfoRepository;

    @Autowired
    private FlightDetailRepository flightDetailRepository;

    @Autowired
    private UserDetailsRepository userDetailsRepository;
/*

    public BookinginfoStruct addBooking( BookinginfoStruct bookinginfoStruct) {
        return this.bookingInfoRepository.save(bookinginfoStruct);
    }
*/


    public List<BookinginfoStruct> findAllBooking()
    {
        return this.bookingInfoRepository.findAll();
    }

    public BookinginfoStruct addBookingDetail(Integer flight_sch_no, Integer userId, BookinginfoStruct bookinginfoStruct) {

        Optional<FlightDetailStruct> byId = flightDetailRepository.findById(flight_sch_no);
        if (!byId.isPresent()) {
            throw new ResourceNotFoundException("Flight with schedule " + flight_sch_no + " does not exist");
        }
        Optional<UserDetailsStruct> byUserId = userDetailsRepository.findById(userId);
        if (! byUserId.isPresent())
        {
            throw new ResourceNotFoundException("User Id  " + userId + " does not exist");
        }
        FlightDetailStruct flightDetailStruct = byId.get();
        bookinginfoStruct.setFlightDetailStruct(flightDetailStruct);

        UserDetailsStruct userDetailsStruct = byUserId.get();

        bookinginfoStruct.setUserDetailsStruct(userDetailsStruct);

        return bookingInfoRepository.save(bookinginfoStruct);
    }


}
