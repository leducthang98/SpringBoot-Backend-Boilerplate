package com.codese.SpringBootBackendBoilderplate.config.security.jwt;

import com.codese.SpringBootBackendBoilderplate.constant.Error;
import com.codese.SpringBootBackendBoilderplate.model.User;
import com.codese.SpringBootBackendBoilderplate.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        // chuẩn thì sẽ là UserWithRole
        User user = userRepository.getUserByUserName(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return new CustomUserDetail(user);
    }

    public UserDetails loadUserById(Long userId) throws Exception {
        // chuẩn thì sẽ là UserWithRole
        User user = userRepository.getUserById(userId);
        if (user == null) {
            throw new Exception(Error.TOKEN_INVALID.getMessage());
        }
        return new CustomUserDetail(user);
    }
}