package com.codese.SpringBootBackendBoilderplate.service.impl;

import com.codese.SpringBootBackendBoilderplate.model.User;
import com.codese.SpringBootBackendBoilderplate.repository.UserRepository;
import com.codese.SpringBootBackendBoilderplate.service.interf.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> getAllUser() {
        return userRepository.getAllUser();
    }

    @Override
    public User getUserByUserName(String username) {
        return userRepository.getUserByUserName(username);
    }
}
