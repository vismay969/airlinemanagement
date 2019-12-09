package com.example.demo.service;

import com.example.demo.entity.FlightDetailStruct;
import com.example.demo.entity.FlightMasterStruct;
import com.example.demo.repository.FlightDetailRepository;
import com.example.demo.repository.FlightMasterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class FlightDetailService {

    @Autowired
    private FlightDetailRepository fdRepo;

    public FlightDetailStruct addFlightDetail(@RequestBody FlightDetailStruct flightDetailStruct) {
        return this.fdRepo.save(flightDetailStruct);
    }


    public List<FlightDetailStruct> findAllFlightDetails()
    {
        return this.fdRepo.findAll();
    }

/*    public List<FlightDetailStruct> findFlightMasterWithArrAndDept(String arr, String dept)
    {
        return this.fmRepo.findByArrAbbrAndDeptAbbr(arr,dept);
    }*/

}
