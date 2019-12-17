package com.example.demo.service;

import com.example.demo.entity.AirportStruct;
import com.example.demo.repository.AirportRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class AirportService {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AirportRepository myRepository;

    public AirportStruct addAirport( AirportStruct airportStruct) throws ResourceNotFoundException
    {
      /*  logger.info("Data provided from GUI : ", airportStruct);
        logger.info("Data GUI : ", airportStruct);*/
        System.out.println(airportStruct);
        try {
            AirportStruct airportStruct1 =  this.myRepository.save(airportStruct);
            logger.info("Airport Created :");
        } catch (Exception e) {
/*
            logger.error("Data : ", airportStruct.toString());
*/
            logger.error("Failed to save the Aiport Data : ", e);
            throw new ResourceNotFoundException("Airport Creation failed ");
           // e.printStackTrace();
        }
        return airportStruct;
    }


    public List<AirportStruct> findAllAirport()
    {
        return this.myRepository.findAll();
    }

}
