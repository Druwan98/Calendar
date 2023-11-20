package com.example.projectCalendar.service;

import com.example.projectCalendar.model.Event;
import com.example.projectCalendar.model.User;
import com.example.projectCalendar.repository.RepoEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServEvent {
    @Autowired
    RepoEvent repoEvent;

    public List<Event> viewAllEvent() {
        return repoEvent.findAll();
    }

    public Event viewEvent(long id) {
        Optional<Event> optionalEvent = repoEvent.findById(id);
        return optionalEvent.orElse(null);
    }

    public void addEvent(Event event) {
        repoEvent.save(event);
    }

    public void deleteEvent(long id) {
        repoEvent.deleteById(id);
    }
}
