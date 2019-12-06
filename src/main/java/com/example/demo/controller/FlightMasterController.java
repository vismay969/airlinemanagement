package com.example.demo.controller;


import com.example.demo.entity.AirportStruct;
import com.example.demo.entity.FlightMasterStruct;
import com.example.demo.exception.MyException;
import com.example.demo.repository.RepositoryFlightMaster;
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

    @PostMapping(value="/flightMaster/add")
    public FlightMasterStruct addFlightMaster(@RequestBody FlightMasterStruct flightMasterStruct) throws MyException {
        try{
            return this.flightMasterService.addFlightMaster(flightMasterStruct);
        } catch (Exception e) {
            System.out.println("in exception===================================================");
            e.printStackTrace();
            throw new MyException(e.getMessage());
        }
    }

    @GetMapping(value="/flightMaster/findAll")
    public List<FlightMasterStruct> findAll()
    {
        return this.flightMasterService.findAllFlightMaster();

    }
}
