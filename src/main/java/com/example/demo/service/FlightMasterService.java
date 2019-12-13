package com.example.demo.service;

import com.example.demo.entity.FlightMasterStruct;
import com.example.demo.repository.FlightMasterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
public class FlightMasterService {

    @Autowired
    private FlightMasterRepository fmRepo;

    public FlightMasterStruct addFlightMaster( FlightMasterStruct flightMasterStruct) {
        return this.fmRepo.save(flightMasterStruct);
    }


    public List<FlightMasterStruct> findAllFlightMaster()
    {
        return this.fmRepo.findAll();
    }

    public Optional<FlightMasterStruct> findAllWithArrDeptDate(int seatsRem, String arr, String dept, LocalDate deptDate) {
        String formattedDate = deptDate.format(DateTimeFormatter.ofPattern("dd-MMM-yyyy"));
        System.out.println(formattedDate);
        LocalDate localDate = LocalDate.parse( formattedDate , DateTimeFormatter.ofPattern("dd-MMM-yyyy"));        //2018-07-14
        System.out.println(localDate);
           return this.fmRepo.findAllWithArrDeptDate(seatsRem, arr, dept, localDate);
/*
            return this.fmRepo.findAllFlightsByDate(seatsRem, arr, dept, localDate);
*/
    }
/*    public List<FlightMasterStruct> findFlightMasterWithArrAndDept(String arr, String dept)
    {
        return this.fmRepo.findAll();
    }*/

}
