package com.codese.SpringBootBackendBoilderplate.service.interf;

import com.codese.SpringBootBackendBoilderplate.model.User;

import java.util.List;

public interface IUserService {
    List<User> getAllUser();
    User getUserByUserName(String username);
}
