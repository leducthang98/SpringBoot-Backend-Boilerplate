package com.codese.SpringBootBackendBoilderplate.config.logger;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoggerConfig {
    @Bean
    public FilterRegistrationBean<LogSystem> loggingFilter() {
        FilterRegistrationBean<LogSystem> registrationBean
                = new FilterRegistrationBean<>();
        registrationBean.setFilter(new LogSystem());
        registrationBean.setOrder(1);
        registrationBean.addUrlPatterns("/*");
        return registrationBean;
    }
}
