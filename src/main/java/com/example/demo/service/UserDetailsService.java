package com.example.demo.service;

import com.example.demo.entity.UserDetailsStruct;
import com.example.demo.repository.UserDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class UserDetailsService {

    @Autowired
    private UserDetailsRepository userDetailsRepository;

    public UserDetailsStruct addUser( UserDetailsStruct userDetailsStruct) {
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

    public UserDetailsStruct findUserByName(String userName)
    {
        Optional<UserDetailsStruct> userFound = this.userDetailsRepository.findByUserName(userName);

        if (!userFound.isPresent()) {
            throw new ResourceNotFoundException("User Not found : Incorrect User Id/Credentials");
        }
        UserDetailsStruct userDetailsStruct = userFound.get();

        return userDetailsStruct;

    }


}
