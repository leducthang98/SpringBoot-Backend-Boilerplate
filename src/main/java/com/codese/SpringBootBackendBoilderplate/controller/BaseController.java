package com.codese.SpringBootBackendBoilderplate.controller;

import com.codese.SpringBootBackendBoilderplate.exception.ApiException;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BaseController {
    private Long userId = null;

    @ModelAttribute("BeforeRequest")
    public void BeforeRequest(HttpServletRequest request, HttpServletResponse response) {
        this.userId = (Long) request.getSession().getAttribute("userId");
    }

    public Long getUserId() {
        return userId;
    }
}
