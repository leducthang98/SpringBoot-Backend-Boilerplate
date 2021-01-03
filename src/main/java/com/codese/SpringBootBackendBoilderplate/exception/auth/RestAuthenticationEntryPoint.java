package com.codese.SpringBootBackendBoilderplate.exception.auth;

import com.codese.SpringBootBackendBoilderplate.constant.Error;
import com.codese.SpringBootBackendBoilderplate.exception.ErrorMessage;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

@Component
public class RestAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
        response.setStatus(Error.UNAUTHORIZED.getCode());
        response.setContentType("application/json");
        ErrorMessage errorMessage = new ErrorMessage(Error.UNAUTHORIZED.getCode(), Error.UNAUTHORIZED.getMessage());
        OutputStream out = response.getOutputStream();
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(out, errorMessage);
        out.flush();

    }
}
