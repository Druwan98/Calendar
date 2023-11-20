package com.example.projectCalendar.repository;

import com.example.projectCalendar.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepoUser extends JpaRepository<User, Long> {
}
