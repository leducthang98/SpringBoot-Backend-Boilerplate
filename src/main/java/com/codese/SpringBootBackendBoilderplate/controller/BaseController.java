package com.codese.SpringBootBackendBoilderplate.controller;

import com.codese.SpringBootBackendBoilderplate.exception.ApiException;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BaseController {
    private String userId = null;

    @ModelAttribute("BeforeRequest")
    public void BeforeRequest(HttpServletRequest request, HttpServletResponse response) {
        this.userId = (String) request.getSession().getAttribute("userId");
    }

    public String getUserId() {
        return userId;
    }
}
