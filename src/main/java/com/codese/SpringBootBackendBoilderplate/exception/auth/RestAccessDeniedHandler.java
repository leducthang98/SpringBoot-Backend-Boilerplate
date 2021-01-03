package com.codese.SpringBootBackendBoilderplate.exception.auth;

import com.codese.SpringBootBackendBoilderplate.constant.Error;
import com.codese.SpringBootBackendBoilderplate.exception.ErrorMessage;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

@Component
public class RestAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException e) throws IOException, ServletException {
        response.setStatus(Error.FORBIDDEN.getCode());
        response.setContentType("application/json");
        ErrorMessage errorMessage = new ErrorMessage(Error.FORBIDDEN.getCode(), Error.FORBIDDEN.getMessage());
        OutputStream out = response.getOutputStream();
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(out, errorMessage);
        out.flush();
    }
}
