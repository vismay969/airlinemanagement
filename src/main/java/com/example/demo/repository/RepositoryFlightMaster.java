package com.example.demo.repository;

import com.example.demo.entity.FlightMasterStruct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryFlightMaster extends JpaRepository<FlightMasterStruct, Integer> {
}
