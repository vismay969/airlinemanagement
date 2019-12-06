package com.example.demo.service;

import com.example.demo.entity.FlightMasterStruct;
import com.example.demo.repository.RepositoryFlightMaster;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightMasterService {

    @Autowired
    private RepositoryFlightMaster repositoryFlightMaster;

    public FlightMasterStruct   addFlightMaster (FlightMasterStruct flightMasterStruct)
    {
        this.repositoryFlightMaster.save(flightMasterStruct);
        return flightMasterStruct;
    }

    public List<FlightMasterStruct> findAllFlightMaster()
    {
        return this.repositoryFlightMaster.findAll();
    }
}
