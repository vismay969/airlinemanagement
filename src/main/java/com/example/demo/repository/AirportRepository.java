package com.example.demo.repository;

import com.example.demo.entity.AirportStruct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirportRepository extends JpaRepository<AirportStruct,String> {
//comment

}