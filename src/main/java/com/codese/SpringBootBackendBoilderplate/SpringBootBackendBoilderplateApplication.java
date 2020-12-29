package com.codese.SpringBootBackendBoilderplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootApplication
public class SpringBootBackendBoilderplateApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringBootBackendBoilderplateApplication.class, args);

    }

}
