package com.example.projectCalendar.repository;

import com.example.projectCalendar.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepoEvent extends JpaRepository<Event, Long> {
}
