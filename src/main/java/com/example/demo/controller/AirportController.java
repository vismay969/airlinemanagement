package com.example.demo.controller;


import com.example.demo.entity.AirportStruct;
import com.example.demo.entity.FlightMasterStruct;
import com.example.demo.service.AirportService;
import com.example.demo.service.FlightMasterService;
import javafx.application.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
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


    @PutMapping(value = "/airport")
    public AirportStruct updateAirport(@RequestBody AirportStruct airportStruct) {
        System.out.println(airportStruct);
        return this.airportService.addAirport(airportStruct);
    }

    @DeleteMapping(value = "/airport")
    public Boolean deleteAirport(@RequestBody AirportStruct airportStruct) {
        System.out.println(airportStruct);
        return this.airportService.deleteAirport(airportStruct);
    }

}
