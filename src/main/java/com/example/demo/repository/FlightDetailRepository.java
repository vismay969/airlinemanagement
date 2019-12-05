package com.example.demo.repository;

import com.example.demo.entity.AirportStruct;
import com.example.demo.entity.FlightDetailStruct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightDetailRepository extends JpaRepository<FlightDetailStruct,String> {


}
