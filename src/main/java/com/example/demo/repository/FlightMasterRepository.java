package com.example.demo.repository;


import com.example.demo.entity.FlightMasterStruct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.NamedNativeQuery;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface FlightMasterRepository extends JpaRepository<FlightMasterStruct,Integer> {
//comment


// org query    @Query(value = "select fm FROM FlightMasterStruct as fm LEFT join fm.flightDetailList as fd where  fd.seats_remaining_business>?1 and fm.arr_abbr=?2 and fm.dept_abbr=?3  and ?4=?4")
    @Query(value = "select fm FROM FlightMasterStruct as fm LEFT join fm.flightDetailList as fd where   fm.arr_abbr='ADI' and fm.dept_abbr='MUM'")
//    @Query(value = "select fm FROM FlightMasterStruct as fm  LEFT join fm.flightDetailList as fd where  fd.seats_remaining_business>?1 and fm.arr_abbr=?2 and fm.dept_abbr=?3 and fd.dept_date='12-NOV-2019' ")
    public Optional<FlightMasterStruct> findAllWithArrDeptDate(int seatsRemaining, String arr, String dept, LocalDate  depDate);

}
