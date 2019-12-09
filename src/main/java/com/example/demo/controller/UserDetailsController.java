package com.example.demo.controller;


import com.example.demo.entity.AirportStruct;
import com.example.demo.entity.UserDetailsStruct;
import com.example.demo.service.AirportService;
import com.example.demo.service.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserDetailsController {


    @Autowired
    private UserDetailsService userDetailsService;


    @PostMapping(value = "/user")
    public UserDetailsStruct addUser(@RequestBody UserDetailsStruct userDetailsStruct) {
            return this.userDetailsService.addUser(userDetailsStruct);
    }

    @GetMapping(value ="/user")
    public List<UserDetailsStruct> findAllUser()
    {
        return this.userDetailsService.findAllUsers();
    }


    @PutMapping(value = "/user")
    public UserDetailsStruct UpdateUser(@RequestBody UserDetailsStruct userDetailsStruct) {
        System.out.println(userDetailsStruct);
     //   Boolean userFound =  this.userDetailsService.findUserById(userDetailsStruct.getUserId());
     //   System.out.println("=======================================" + userFound);
        return this.userDetailsService.addUser(userDetailsStruct);
    }


}
