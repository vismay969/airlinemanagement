package com.example.demo.service;

import com.example.demo.entity.AirportStruct;
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

    public AirportStruct addCatalog(@RequestBody AirportStruct airportStruct)
    {
        return this.myRepository.save(airportStruct);
    }


    public List<AirportStruct> findAll()
    {
        return this.myRepository.findAll();
    }

}
