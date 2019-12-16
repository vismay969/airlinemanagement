package com.example.demo.repository;

import com.example.demo.entity.AirportStruct;
import com.example.demo.entity.BookinginfoStruct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface BookingInfoRepository extends JpaRepository<BookinginfoStruct,Integer> {
//comment

    public List<BookinginfoStruct> findByUserDetailsStruct_UserIdEqualsAndFlightDateGreaterThanEqualAndStatusFlag(int userId, LocalDateTime lDate,String flag);


    List<BookinginfoStruct> findByUserDetailsStruct_UserIdEqualsOrderByFlightDate(Integer userId);
}
