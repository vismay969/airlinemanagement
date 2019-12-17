package com.example.demo.service;

import com.example.demo.entity.UserDetailsStruct;
import com.example.demo.repository.UserDetailsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class UserDetailsService {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserDetailsRepository userDetailsRepository;

    public UserDetailsStruct addUser( UserDetailsStruct userDetailsStruct) {
        logger.info("Adding new user");
        try {
            UserDetailsStruct userCreated = this.userDetailsRepository.save(userDetailsStruct);
            return userCreated;
        } catch (Exception e) {
            logger.error("User creation failed : ",e);
            throw new ResourceNotFoundException("User Creation failed ");
           // e.printStackTrace();
        }

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


    public UserDetailsStruct findUserByNamePwd(String userName, String password) {

        Optional<UserDetailsStruct> userFound = this.userDetailsRepository.findByUserNameAndPassword(userName, password);

        if (!userFound.isPresent()) {
            throw new ResourceNotFoundException("User Not found : Incorrect User Id/Credentials");
        }
        UserDetailsStruct userDetailsStruct = userFound.get();

        return userDetailsStruct;

    }
}
