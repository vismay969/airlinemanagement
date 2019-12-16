package com.example.demo.repository;

import com.example.demo.entity.AirportStruct;
import com.example.demo.entity.FlightDetailStruct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightDetailRepository extends JpaRepository<FlightDetailStruct,Integer> {



}
