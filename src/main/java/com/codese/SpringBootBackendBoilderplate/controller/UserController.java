package com.codese.SpringBootBackendBoilderplate.controller;

import com.codese.SpringBootBackendBoilderplate.helper.ResponseBuilder;
import com.codese.SpringBootBackendBoilderplate.model.User;
import com.codese.SpringBootBackendBoilderplate.service.implementation.UserServiceImpl;
import com.codese.SpringBootBackendBoilderplate.service.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController extends BaseController {
    @Autowired
    IUserService userService;

    @GetMapping("/all")
    public ResponseEntity<ResponseBuilder<List<User>>> getAllUser() {
        System.out.println("user detail at controller:" + this.getUserId());
        return ResponseEntity.ok(ResponseBuilder.buildResponse(userService.getAllUser()));
    }

    @GetMapping("/get-by-username")
    public ResponseEntity<ResponseBuilder<User>> getUserByUserName(@RequestParam(required = true) String username) {
        return ResponseEntity.ok(ResponseBuilder.buildCustomResponse(userService.getUserByUserName(username), 200, "ok"));
    }
}
