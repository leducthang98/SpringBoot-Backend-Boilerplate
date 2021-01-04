package com.codese.SpringBootBackendBoilderplate.controller;

import com.codese.SpringBootBackendBoilderplate.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/")
public class DefaultController {
    @Autowired
    private RedisTemplate template;

    @GetMapping("/")
    public String defaultController() {
        return "ok";
    }

    @GetMapping("admin-only")
    public String adminOnly() {
        return "admin only";
    }

    @GetMapping("redis-check")
    public List<User> setRedisDemo(@RequestParam(required = false,defaultValue = "Lê Đức Thắng") String redisValue) {
        // users must be Serializable
        ArrayList<User> users = new ArrayList<>();
        User user = new User();
        UUID id = UUID.randomUUID();
        user.setId(id.toString());
        user.setUsername(redisValue);
        user.setPassword("redisTestPass");
        users.add(user);

        template.opsForValue().set("UserArrayTest", users);
        return (List<User>) template.opsForValue().get("UserArrayTest");
    }

}
