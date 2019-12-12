package com.example.demo.repository;


import com.example.demo.entity.FlightMasterStruct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface FlightMasterRepository extends JpaRepository<FlightMasterStruct,Integer> {
//comment


    @Query(value = "select fm FROM FlightMasterStruct as fm LEFT join fm.flightDetailList as fd where  fd.seats_booked_business>?1 and fm.arr_abbr=?2 and fm.dept_abbr=?3  and fd.dept_date=?4")
    public Optional<FlightMasterStruct> findAllWithArrDeptDate(int seatsRemaining, String arr, String dept, Date depDate);
}
