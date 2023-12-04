package com.example.projectCalendar.repository;

import com.example.projectCalendar.model.Event;
import com.example.projectCalendar.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepoUser extends JpaRepository<User, Integer> {
    @Modifying
    @Query("UPDATE User u SET u.username = :username, " +
            "u.password = :password " +
            "WHERE u.id = :id")
    void updateUser(@Param("id") int id,
                    @Param("username") String username,
                    @Param("password") String password);
}
