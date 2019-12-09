package com.example.demo.service;

import com.example.demo.entity.UserDetailsStruct;
import com.example.demo.repository.UserDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class UserDetailsService {

    @Autowired
    private UserDetailsRepository userDetailsRepository;

    public UserDetailsStruct addUser(@RequestBody UserDetailsStruct userDetailsStruct) {
        return this.userDetailsRepository.save(userDetailsStruct);
    }


    public List<UserDetailsStruct> findAllUsers()
    {
        return this.userDetailsRepository.findAll();
    }

    public boolean findUserById(Integer userid)
    {
        /*return this.userDetailsRepository.existsById(userid);*/
        return false;
    }


}
