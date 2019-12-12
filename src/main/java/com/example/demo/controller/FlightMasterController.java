package com.example.demo.controller;


import com.example.demo.entity.AirportStruct;
import com.example.demo.entity.FlightMasterStruct;
import com.example.demo.service.AirportService;
import com.example.demo.service.FlightDetailService;
import com.example.demo.service.FlightMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

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

    @GetMapping(value = "/flightMaster/{seatsRem}/{arr}/{dept}/{deptDate}")
    public Optional<FlightMasterStruct> findAllWithArrDeptDate(@PathVariable(value = "seatsRem") int dep_date, @PathVariable(value = "arr") String arr, @PathVariable(value = "dept") String dept, @PathVariable(value = "deptDate") String deptDate) {
        Date depDate = null;
        try {
            System.out.println(deptDate);
            depDate = new SimpleDateFormat("yyyy-MM-dd").parse(deptDate);
            System.out.println(depDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return this.flightMasterService.findAllWithArrDeptDate(dep_date, arr, dept, depDate);
    }
}
