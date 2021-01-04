package com.codese.SpringBootBackendBoilderplate.repository.interfaces;

import com.codese.SpringBootBackendBoilderplate.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserRepository extends JpaRepository<User, String> {

    User findByUsername(String username);

    @Query(value = "Select * from account where id = ?1", nativeQuery = true)
    User findOneById(String userId);
}
