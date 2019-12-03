package com.example.demo.controller;


import com.example.demo.entity.AirportStruct;
import com.example.demo.service.AirportService;
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

    @PostMapping(value = "/airport/add")
    public AirportStruct addAirport(@RequestBody AirportStruct airportStruct)
    {
        try {
            return this.airportService.addAirport(airportStruct);
        } catch (Exception e) {

        }
        return airportStruct;
    }


    @GetMapping(value ="/airport/findAll")
    public List<AirportStruct> findAll()
    {
        return this.airportService.findAllAirport();
    }

}
