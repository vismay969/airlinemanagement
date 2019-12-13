package com.example.demo.controller;


import com.example.demo.entity.AirportStruct;
import com.example.demo.entity.FlightDetailStruct;
import com.example.demo.entity.FlightMasterStruct;
import com.example.demo.exception.MyResourceNotFoundException;
import com.example.demo.service.AirportService;
import com.example.demo.service.FlightDetailService;
import com.example.demo.service.FlightMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
public class FlightDetailController {


    @Autowired
    private FlightDetailService flightDetailService;

    @PostMapping(value = "/flightDetail/{flightNo}")
    public FlightDetailStruct addFlightDetail(@PathVariable(value = "flightNo") Integer flightNo, @RequestBody FlightDetailStruct flightDetailStruct) {
            return this.flightDetailService.addFlightDetail(flightNo,flightDetailStruct);
    }

    @GetMapping(value ="/flightDetail")
    public List<FlightDetailStruct> findAllFlightDetail()
    {
        return this.flightDetailService.findAllFlightDetails();
    }


    @GetMapping(value ="/flightDetail/{flightSchNo}")
    public Optional<FlightDetailStruct> findFlightDetailById(@PathVariable(value = "flightSchNo") Integer flightSchNo)
    {
        try{
            return this.flightDetailService.getFlightDetailsById(flightSchNo);
        }
        catch (MyResourceNotFoundException exc) {
        throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Data Not Found", exc);
    }
    }


}
