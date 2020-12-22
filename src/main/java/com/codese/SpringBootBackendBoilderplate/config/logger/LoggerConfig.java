package com.codese.SpringBootBackendBoilderplate.config.logger;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoggerConfig {
    @Bean
    public FilterRegistrationBean<Logger> loggingFilter(){
        FilterRegistrationBean<Logger> registrationBean
                = new FilterRegistrationBean<>();
        registrationBean.setFilter(new Logger());
        registrationBean.setOrder(1);
        registrationBean.addUrlPatterns("/**");
        return registrationBean;
    }
}
