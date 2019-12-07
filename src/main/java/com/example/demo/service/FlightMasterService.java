package com.example.demo.service;

import com.example.demo.entity.FlightMasterStruct;
import com.example.demo.repository.FlightMasterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class FlightMasterService {

    @Autowired
    private FlightMasterRepository fmRepo;

    public FlightMasterStruct addFlightMaster(@RequestBody FlightMasterStruct flightMasterStruct) {
        return this.fmRepo.save(flightMasterStruct);
    }


    public List<FlightMasterStruct> findAllFlightMaster()
    {
        return this.fmRepo.findAll();
    }

    public List<FlightMasterStruct> findFlightMasterWithArrAndDept(String arr, String dept)
    {
        return this.fmRepo.findAll();
    }

}
