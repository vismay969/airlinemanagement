package com.example.demo.controller;


import com.example.demo.entity.AirportStruct;
import com.example.demo.entity.FlightDetailStruct;
import com.example.demo.entity.FlightMasterStruct;
import com.example.demo.service.AirportService;
import com.example.demo.service.FlightDetailService;
import com.example.demo.service.FlightMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
        return this.flightDetailService.getFlightDetailsById(flightSchNo);
    }


}
