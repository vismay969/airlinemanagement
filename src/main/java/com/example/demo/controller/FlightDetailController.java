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

@RestController
@CrossOrigin("*")
public class FlightDetailController {


    @Autowired
    private FlightDetailService flightDetailService;

    @PostMapping(value = "/flightDetail")
    public FlightDetailStruct addFlightDetail(@RequestBody FlightDetailStruct flightDetailStruct) {
            return this.flightDetailService.addFlightDetail(1, flightDetailStruct);
    }

    @GetMapping(value ="/flightDetail")
    public List<FlightDetailStruct> findAll()
    {
        return this.flightDetailService.findAllFlightDetails();
    }


    @PutMapping(value = "/flightDetail")
    public FlightDetailStruct updateFlightDetail(@RequestBody FlightDetailStruct flightDetailStruct) {
        return this.flightDetailService.addFlightDetail(1, flightDetailStruct);
    }
}
