package com.example.demo.service;

import com.example.demo.entity.AirportStruct;
import com.example.demo.exception.MyException;
import com.example.demo.repository.MyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class AirportService {

    @Autowired
    private MyRepository myRepository;

    public AirportStruct addAirport(@RequestBody AirportStruct airportStruct) throws MyException {
        return  this.myRepository.save(airportStruct);
    }


    public List<AirportStruct> findAllAirport()
    {
        return this.myRepository.findAll();

    }


    /** documentation */
    public String deleteByLocationAbbr(AirportStruct airportStruct) {
        String returnMessage="Airport not found for location abbr : ";
        if (this.myRepository.existsById(airportStruct.getLocation_abbr()))
        {
            this.myRepository.delete(airportStruct);
            returnMessage= "Airport Deleted";
        }
        return returnMessage;
    }

}
