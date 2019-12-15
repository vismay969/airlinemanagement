package com.example.demo.repository;

import com.example.demo.entity.AirportStruct;
import com.example.demo.entity.UserDetailsStruct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDetailsRepository extends JpaRepository<UserDetailsStruct,Integer> {
//comment
    public Optional<UserDetailsStruct> findByUserName(String userName);

    Optional<UserDetailsStruct> findByUserNameAndPassword(String userName, String password);
}
