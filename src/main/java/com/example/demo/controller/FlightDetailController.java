package com.example.demo.controller;


import com.example.demo.entity.AirportStruct;
import com.example.demo.entity.FlightDetailStruct;
import com.example.demo.entity.FlightMasterStruct;
import com.example.demo.service.AirportService;
import com.example.demo.service.FlightDetailService;
import com.example.demo.service.FlightMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FlightDetailController {


    @Autowired
    private FlightDetailService flightDetailService;

    @PostMapping(value = "/flightDetail")
    public FlightDetailStruct addAirport(@RequestBody FlightDetailStruct flightDetailStruct) {
            return this.flightDetailService.addFlightDetail(flightDetailStruct);
    }

    @GetMapping(value ="/flightDetail")
    public List<FlightDetailStruct> findAll()
    {
        return this.flightDetailService.findAllFlightDetails();
    }

}
