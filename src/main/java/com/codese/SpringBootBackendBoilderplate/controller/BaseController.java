package com.codese.SpringBootBackendBoilderplate.controller;

import com.codese.SpringBootBackendBoilderplate.exception.ApiException;
import com.codese.SpringBootBackendBoilderplate.model.User;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BaseController {
    private User userDetail = null;

    @ModelAttribute("BeforeRequest")
    public void BeforeRequest(HttpServletRequest request, HttpServletResponse response) {
        this.userDetail = (User) request.getSession().getAttribute("userDetail");
    }

    public User getUserId() {
        return userDetail;
    }
}
