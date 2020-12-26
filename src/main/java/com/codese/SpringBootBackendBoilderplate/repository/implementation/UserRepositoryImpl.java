//package com.codese.SpringBootBackendBoilderplate.repository.implementation;
//
//import com.codese.SpringBootBackendBoilderplate.helper.jdbc_mapper.UserMapper;
//import com.codese.SpringBootBackendBoilderplate.model.User;
//import com.codese.SpringBootBackendBoilderplate.repository.interfaces.IUserRepository;
//import com.codese.SpringBootBackendBoilderplate.service.interfaces.IUserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.stereotype.Repository;
//import java.util.List;
//
//@Repository
//public class UserRepositoryImpl {
//
//    public List<User> getAllUser() {
//        String sql = "Select * from account";
//        return jdbcTemplate.query(sql, new UserMapper());
//    }
//
//    public User getUserByUserName(String username) {
//        System.out.println("get user by username");
//        String sql = "Select * from account where username = ?";
//        return jdbcTemplate.queryForObject(sql, new UserMapper(), new Object[]{username});
//    }
//
//    public User getUserById(Long userId) {
//        System.out.println("get user by userid");
//        String sql = "Select * from account where id = ?";
//        return jdbcTemplate.queryForObject(sql, new UserMapper(), new Object[]{userId});
//    }
//}
//
// >> NOTE: YOU CAN USE THIS IF USE USE JDBC TEMPLATE