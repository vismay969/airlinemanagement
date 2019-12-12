package com.example.demo.service;

import com.example.demo.entity.AirportStruct;
import com.example.demo.repository.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class AirportService {

    @Autowired
    private AirportRepository myRepository;

    public AirportStruct addAirport( AirportStruct airportStruct) {
        return this.myRepository.save(airportStruct);
    }


    public List<AirportStruct> findAllAirport()
    {
        return this.myRepository.findAll();
    }

}
