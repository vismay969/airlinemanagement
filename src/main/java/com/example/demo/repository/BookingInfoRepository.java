package com.example.demo.repository;

import com.example.demo.entity.AirportStruct;
import com.example.demo.entity.BookinginfoStruct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingInfoRepository extends JpaRepository<BookinginfoStruct,Integer> {
//comment

}
