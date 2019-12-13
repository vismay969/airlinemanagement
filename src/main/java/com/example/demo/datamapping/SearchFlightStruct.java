package com.example.demo.datamapping;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Data
@NoArgsConstructor
public class SearchFlightStruct {
    private int flightNo ;
    private String airline;
    private String dept_abbr;
    private String arr_abbr;
    private int noOfSeats_first;
    private int noOfSeats_business;
    private int flight_sch_No ;
    private LocalDate dept_date;
    private LocalDateTime dept_time;
    private LocalDate arr_date;
    private LocalDateTime arr_time;
    private double fare_first;
    private int seats_remaining_first;
    private double fare_business;
    private int seats_remaining_business;
    private String status_flag;
    public SearchFlightStruct(int flightNo, String airline, String dept_abbr, String arr_abbr, int noOfSeats_first, int noOfSeats_business, int flight_sch_No, LocalDate dept_date, LocalDateTime dept_time, LocalDate arr_date, LocalDateTime arr_time, double fare_first, int seats_remaining_first, double fare_business, int seats_remaining_business, String status_flag) {
        this.flightNo = flightNo;
        this.airline = airline;
        this.dept_abbr = dept_abbr;
        this.arr_abbr = arr_abbr;
        this.noOfSeats_first = noOfSeats_first;
        this.noOfSeats_business = noOfSeats_business;
        this.flight_sch_No = flight_sch_No;
        this.dept_date = dept_date;
        this.dept_time = dept_time;
        this.arr_date = arr_date;
        this.arr_time = arr_time;
        this.fare_first = fare_first;
        this.seats_remaining_first = seats_remaining_first;
        this.fare_business = fare_business;
        this.seats_remaining_business = seats_remaining_business;
        this.status_flag = status_flag;
    }
}
