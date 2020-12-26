package com.codese.SpringBootBackendBoilderplate.service.interfaces;

import com.codese.SpringBootBackendBoilderplate.model.User;

import java.util.List;

public interface IUserService {
    List<User> getAllUser();
    User getUserByUserName(String username);
}
