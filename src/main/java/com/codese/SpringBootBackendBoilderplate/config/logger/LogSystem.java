package com.codese.SpringBootBackendBoilderplate.config.logger;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Enumeration;

@Slf4j
public class LogSystem implements Filter {

    Logger logger = LoggerFactory.getLogger(LogSystem.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Just System Log");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
//      ContentCachingRequestWrapper cacheReq = new ContentCachingRequestWrapper(httpRequest);
        String bodyData = "";
        String paramsData = "";
        String headerData = "";
//      ObjectMapper objectMapper = new ObjectMapper();
//      Object objectFromBody = objectMapper.readValue(cacheReq.getReader(), Object.class);
        Enumeration<String> headerNames = httpRequest.getHeaderNames();
        if (headerNames != null) {
            while (headerNames.hasMoreElements()) {
                headerData += httpRequest.getHeader(headerNames.nextElement()) + ", ";
            }
        }
        bodyData = "Chưa nghĩ ra cách lấy body";
        paramsData = httpRequest.getQueryString();
        logger.info("-------------------------------");
        logger.info(httpRequest.getMethod() + ": " + httpRequest.getRequestURL());
        logger.info("Headers: " + headerData);
        logger.info("Params: " + paramsData);
        logger.info("Body: " + bodyData);
        logger.info("-------------------------------");
        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
