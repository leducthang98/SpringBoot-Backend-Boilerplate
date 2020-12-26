package com.codese.SpringBootBackendBoilderplate.repository.interfaces;

import com.codese.SpringBootBackendBoilderplate.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IUserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

    @Query(value = "Select * from account where id = ?1", nativeQuery = true)
    User findOneById(Long userId);
}
