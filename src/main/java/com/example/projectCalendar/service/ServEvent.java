package com.example.projectCalendar.service;

import com.example.projectCalendar.model.Calendar;
import com.example.projectCalendar.model.Event;
import com.example.projectCalendar.repository.RepoEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServEvent {
    @Autowired
    RepoEvent repoEvent;

    public List<Event> viewAllEvent(){
        return repoEvent.findAll();
    }
    public void addEvent(Event event){
        repoEvent.save(event);
    }
    public void deleteEvent(long id){
        repoEvent.deleteById(id);
    }
}
