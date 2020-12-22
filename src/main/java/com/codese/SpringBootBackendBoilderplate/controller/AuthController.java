package com.codese.SpringBootBackendBoilderplate.controller;

import com.codese.SpringBootBackendBoilderplate.config.security.jwt.Jwt;
import com.codese.SpringBootBackendBoilderplate.config.security.jwt.JwtAuthenticationRequest;
import com.codese.SpringBootBackendBoilderplate.config.security.jwt.JwtAuthenticationResponse;
import com.codese.SpringBootBackendBoilderplate.constant.Error;
import com.codese.SpringBootBackendBoilderplate.exception.ApiException;
import com.codese.SpringBootBackendBoilderplate.helper.ResponseBuilder;
import com.codese.SpringBootBackendBoilderplate.model.User;
import com.codese.SpringBootBackendBoilderplate.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    Jwt jwtUtil;

    @Autowired
    UserServiceImpl userService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public ResponseEntity<ResponseBuilder<JwtAuthenticationResponse>> login(@RequestBody JwtAuthenticationRequest jwtAuthenticationRequest) throws ApiException {
        try {
            User user = userService.getUserByUserName(jwtAuthenticationRequest.getUsername());
            boolean isPasswordValid = BCrypt.checkpw(jwtAuthenticationRequest.getPassword(), user.getPassword());
            if (isPasswordValid) {
                Map<String, Object> claims = new HashMap<>();
                String jwt = jwtUtil.createToken(claims, user.getId());
                JwtAuthenticationResponse jwtAuthenticationResponse = new JwtAuthenticationResponse(jwt);
                return ResponseEntity.ok(ResponseBuilder.buildResponse(jwtAuthenticationResponse));
            } else {
                throw new ApiException(Error.INVALID_USERNAME_OR_PASSWORD.getMessage());
            }
        } catch (Exception e) {
            throw new ApiException(Error.INVALID_USERNAME_OR_PASSWORD.getMessage());
        }
    }
}
