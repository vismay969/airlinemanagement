package com.example.demo.service;

import com.example.demo.datamapping.SearchFlightStruct;
import com.example.demo.entity.AirportStruct;
import com.example.demo.entity.BookinginfoStruct;
import com.example.demo.entity.FlightDetailStruct;
import com.example.demo.entity.UserDetailsStruct;
import com.example.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class BookingInfoService {

    @Autowired
    private BookingInfoRepository bookingInfoRepository;

    @Autowired
    private FlightDetailRepository flightDetailRepository;

    @Autowired
    private FlightMasterRepository flightMasterRepository;

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

    public BookinginfoStruct findbyBookingId(int booking_id)
    {
        Optional<BookinginfoStruct> optional = this.bookingInfoRepository.findById(booking_id);
        return optional.orElseGet(BookinginfoStruct::new);
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


    public List<BookinginfoStruct> findByUserIdandCurrentDate(Integer userId, LocalDateTime lDate)
    {
        return this.bookingInfoRepository.findByUserDetailsStruct_UserIdEqualsAndFlightDateGreaterThanEqualAndStatusFlag(userId,lDate,"N");
    }



    public BookinginfoStruct softDeleteBookingId(BookinginfoStruct bookinginfoStruct)
    {
         bookinginfoStruct.setStatusFlag("Y");
        int bookingId = bookinginfoStruct.getBooking_id();

        Optional<SearchFlightStruct> searchFlightStruct = this.flightMasterRepository.findFlightMasterDetailsbyBookingId(bookingId);
        int flightSchNo = searchFlightStruct.get().getFlight_sch_No();

        Optional<FlightDetailStruct> byId = flightDetailRepository.findById(flightSchNo);
        if (!byId.isPresent()) {
            throw new ResourceNotFoundException("Flight details with id " + flightSchNo + " does not exist");
        }
        FlightDetailStruct flightDetailStruct = byId.get();
        // to reduce the seats in flightDetail

        //System.out.println(flightDetailStruct.getSeats_remaining_business() );


        if (bookinginfoStruct.getClass_type().toUpperCase().equals("BUSINESS")) {
                flightDetailStruct.setSeats_remaining_business(flightDetailStruct.getSeats_remaining_business() + bookinginfoStruct.getNoOfPass());
        }
        else {

                flightDetailStruct.setSeats_remaining_first(flightDetailStruct.getSeats_remaining_first() + bookinginfoStruct.getNoOfPass());

        }
        BookinginfoStruct bi = this.bookingInfoRepository.save(bookinginfoStruct);
        FlightDetailStruct fd = flightDetailRepository.save(flightDetailStruct);
        //  System.out.println(flightDetailStruct.getSeats_remaining_first() + " seat first");

        return bi;


    }

}
