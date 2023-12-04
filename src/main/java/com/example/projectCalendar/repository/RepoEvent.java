package com.example.projectCalendar.repository;

import com.example.projectCalendar.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface RepoEvent extends JpaRepository<Event, Integer> {
    @Modifying
    @Query("UPDATE Event e SET e.title = :title, " +
            "e.description = :description, " +
            "e.dateTimeStart = :dateTimeStart, " +
            "e.dateTimeEnd = :dateTimeEnd, " +
            "e.location = :location " +
            "WHERE e.id = :id")
    void updateEvent(@Param("id") int id,
                     @Param("title") String title,
                     @Param("description") String description,
                     @Param("dateTimeStart") LocalDateTime dateTimeStart,
                     @Param("dateTimeEnd") LocalDateTime dateTimeEnd,
                     @Param("location") LocalDateTime location);
}
