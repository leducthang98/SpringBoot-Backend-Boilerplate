package com.codese.SpringBootBackendBoilderplate.repository;

import com.codese.SpringBootBackendBoilderplate.helper.jdbc_mapper.UserMapper;
import com.codese.SpringBootBackendBoilderplate.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<User> getAllUser() {
        String sql = "Select * from account";
        return jdbcTemplate.query(sql, new UserMapper());
    }

    public User getUserByUserName(String username) {
        System.out.println("get user by username");
        String sql = "Select * from account where username = ?";
        return jdbcTemplate.queryForObject(sql, new UserMapper(), new Object[]{username});
    }

}
