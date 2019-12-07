package com.example.demo.controller;


import com.example.demo.entity.AirportStruct;
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
public class FlightMasterController {


    @Autowired
    private FlightMasterService flightMasterService;


    @PostMapping(value = "/flightMaster")
    public FlightMasterStruct addFlightMaster(@RequestBody FlightMasterStruct flightMasterStruct) {
            return this.flightMasterService.addFlightMaster(flightMasterStruct);
    }

    @GetMapping(value ="/flightMaster")
    public List<FlightMasterStruct> findAllFlightMaster()
    {
        return this.flightMasterService.findAllFlightMaster();//findFlightMasterWithArrAndDept("bom","del");
    }

}
