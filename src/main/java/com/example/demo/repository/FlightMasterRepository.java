package com.example.demo.repository;


import com.example.demo.datamapping.SearchFlightStruct;
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


    // @Query(value = "select fm FROM FlightMasterStruct as fm LEFT join fm.flightDetailList as fd where  fd.seats_remaining_business>?1 and fm.arr_abbr=?2 and fm.dept_abbr=?3  and ?4=?4")
   /*  original working qry
    @Query(value = "select " +
            " new com.example.demo.datamapping.SearchFlightStruct(" +
            "fm.flightNo,fm.airline,fm.dept_abbr,fm.arr_abbr," +
            "fm.noOfSeats_first,fm.noOfSeats_business," +
            "fd.flight_sch_No,fd.dept_date,fd.dept_time,fd.arr_date," +
            "fd.arr_time,fd.fare_first,fd.seats_remaining_first," +
            "fd.fare_business,fd.seats_remaining_business,fd.status_flag) " +
            " FROM FlightMasterStruct as fm join fm.flightDetailList as fd " +
            " where  fd.seats_remaining_business>=?1 and fd.seats_remaining_first>=?2 and fm.arr_abbr=?3 " +
            " and fm.dept_abbr=?4  and fd.dept_date>=?5 and fd.status_flag='N' ")
*/


   // query to include where  dept_time > CURRENT_TIMESTAMP
    @Query(value = "select " +
            " new com.example.demo.datamapping.SearchFlightStruct(" +
            "fm.flightNo,fm.airline,fm.dept_abbr,fm.arr_abbr," +
            "fm.noOfSeats_first,fm.noOfSeats_business," +
            "fd.flight_sch_No,fd.dept_date,fd.dept_time,fd.arr_date," +
            "fd.arr_time,fd.fare_first,fd.seats_remaining_first," +
            "fd.fare_business,fd.seats_remaining_business,fd.status_flag) " +
            " FROM FlightMasterStruct as fm join fm.flightDetailList as fd " +
            " where  fd.seats_remaining_business>=?1 and fd.seats_remaining_first>=?2 and fm.arr_abbr=?3 " +
            " and fm.dept_abbr=?4  and fd.dept_date>=?5 and fd.dept_time > CURRENT_TIMESTAMP and fd.status_flag='N' order by  fd.dept_time ")

    public List<SearchFlightStruct> findAllWithArrDeptDate(int seatsRemainingBusiness, int seatsRemainingFirst, String arr, String dept, LocalDate  depDate);


    @Query(value = "select distinct" +
            " new com.example.demo.datamapping.SearchFlightStruct(" +
            "fm.flightNo,fm.airline,fm.dept_abbr,fm.arr_abbr," +
            "fm.noOfSeats_first,fm.noOfSeats_business," +
            "fd.flight_sch_No,fd.dept_date,fd.dept_time,fd.arr_date," +
            "fd.arr_time,fd.fare_first,fd.seats_remaining_first," +
            "fd.fare_business,fd.seats_remaining_business,fd.status_flag) " +
            " FROM FlightMasterStruct as fm join fm.flightDetailList as fd join fd.bookinginfoList as bi " +
            " where  bi.booking_id>=?1")

    public Optional<SearchFlightStruct> findFlightMasterDetailsbyBookingId(int bookingId);
}
