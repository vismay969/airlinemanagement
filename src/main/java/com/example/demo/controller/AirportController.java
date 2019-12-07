package com.example.demo.controller;


import com.example.demo.entity.AirportStruct;
import com.example.demo.exception.MyException;
import com.example.demo.service.AirportService;
import javafx.application.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AirportController {


    @Autowired
    private AirportService airportService;

    @PostMapping(value = "/airport/add")
    public AirportStruct addAirport(@RequestBody AirportStruct airportStruct) throws MyException {
        try {
            return this.airportService.addAirport(airportStruct);
        } catch (Exception e) {
            System.out.println(e.getMessage()   );
            throw new MyException( e.getMessage()  );

        }
    }

    @GetMapping(value ="/airport/findAll")
    public List<AirportStruct> findAll()
    {
        return this.airportService.findAllAirport();
    }

  /*  @DeleteMapping(value="/airport/delete")
    public String deleteAirportById(@RequestBody AirportStruct airportStruct)
    {
        return this.airportService.deleteByLocationAbbr(airportStruct);
    }*/

}
