package com.example.demo.controller;


import com.example.demo.entity.AirportStruct;
import com.example.demo.service.AirportService;
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

    @PostMapping(value = "/airport/add" )
    public AirportStruct addCatalog(@RequestBody AirportStruct airportStruct)
    {
        return this.airportService.addCatalog(airportStruct);
    }


    @GetMapping(value ="/airport/findAll")
    public List<AirportStruct> findAll()
    {
        return this.airportService.findAll();
    }

}
