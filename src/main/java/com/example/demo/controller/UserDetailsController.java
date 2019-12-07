package com.example.demo.controller;


import com.example.demo.entity.AirportStruct;
import com.example.demo.entity.UserDetailsStruct;
import com.example.demo.service.AirportService;
import com.example.demo.service.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

}
