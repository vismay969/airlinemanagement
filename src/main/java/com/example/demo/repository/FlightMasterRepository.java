package com.example.demo.repository;


import com.example.demo.entity.FlightMasterStruct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightMasterRepository extends JpaRepository<FlightMasterStruct,Integer> {
//comment



    //List<FlightMasterStruct> findByArrAbbrAndDeptAbbr(String arr, String dept);
}
