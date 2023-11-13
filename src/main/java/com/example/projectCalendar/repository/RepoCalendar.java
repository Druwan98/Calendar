package com.example.projectCalendar.repository;

import com.example.projectCalendar.model.Calendar;
import com.example.projectCalendar.model.Event;
import com.example.projectCalendar.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface RepoCalendar extends JpaRepository<Calendar,Long> {
//    @Modifying
//    @Query("UPDATE calendar c SET c.user = :user, c.event = :event")
//    void updateCalendar(@Param("id") long id, @Param("username") User user, @Param("event") List<Event> event);
}
