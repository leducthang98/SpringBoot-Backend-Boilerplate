//package com.codese.SpringBootBackendBoilderplate.helper.jdbc_mapper;
//
//import com.codese.SpringBootBackendBoilderplate.model.User;
//import org.springframework.jdbc.core.RowMapper;
//
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//public class UserMapper implements RowMapper<User> {
//    @Override
//    public User mapRow(ResultSet resultSet, int i) throws SQLException {
//        User user = new User();
//        user.setId(resultSet.getLong("id"));
//        user.setUsername(resultSet.getString("username"));
//        user.setPassword(resultSet.getString("password"));
//        return user;
//    }
//}
//
// >> NOTE: YOU CAN USE THIS IF USE USE JDBC TEMPLATE