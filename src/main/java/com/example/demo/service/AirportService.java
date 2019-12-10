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
    private AirportRepository airportRepository;

    public AirportStruct addAirport(@RequestBody AirportStruct airportStruct) {
        return this.airportRepository.save(airportStruct);
    }


    public List<AirportStruct> findAllAirport()
    {
        return this.airportRepository.findAll();
    }

    public Boolean deleteAirport(AirportStruct airportStruct) {
        boolean rowDeleted=false;
        if (this.airportRepository.existsById(airportStruct.getLocation_abbr()))
        {
            this.airportRepository.delete(airportStruct);
            rowDeleted=true;
        }
        return rowDeleted;
    }
}
