package com.csm.LibraryManagementim.service;

import com.csm.LibraryManagementim.model.User;
import com.csm.LibraryManagementim.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;


    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
