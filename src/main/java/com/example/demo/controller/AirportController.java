package com.example.demo.controller;


import com.example.demo.entity.AirportStruct;
import com.example.demo.entity.FlightMasterStruct;
import com.example.demo.service.AirportService;
import com.example.demo.service.FlightMasterService;
import javafx.application.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AirportController {


    @Autowired
    private AirportService airportService;


    @PostMapping(value = "/airport")
    public AirportStruct addAirport(@RequestBody AirportStruct airportStruct) {
            return this.airportService.addAirport(airportStruct);
    }

    @GetMapping(value ="/airport")
    public List<AirportStruct> findAllAirport()
    {
        return this.airportService.findAllAirport();
    }

}
