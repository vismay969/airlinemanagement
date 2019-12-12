package com.example.demo.repository;

import com.example.demo.entity.AirportStruct;
import com.example.demo.entity.UserDetailsStruct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDetailsRepository extends JpaRepository<UserDetailsStruct,Integer> {
//comment

}
