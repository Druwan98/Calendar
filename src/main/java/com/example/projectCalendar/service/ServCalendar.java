package com.example.projectCalendar.service;

import com.example.projectCalendar.model.Calendar;
import com.example.projectCalendar.model.Event;
import com.example.projectCalendar.model.User;
import com.example.projectCalendar.repository.RepoCalendar;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ServCalendar {
    @Autowired
    RepoCalendar repoCalendar;

    public List<Calendar> viewAllCalendar(){
        return repoCalendar.findAll();
    }
    public void addCalendar(Calendar calendar){
        repoCalendar.save(calendar);
    }
    public void deleteCalendar(long id){
        repoCalendar.deleteById(id);
    }

//    @Transactional
//    public void updateCalendar(long id, Optional<User> username, Optional<List<Event>> event){
//
//        Calendar calendar = repoCalendar.getReferenceById(id);
//
//        if (calendar != null){
//            username.ifPresent(calendar::setUser);
//            event.ifPresent(calendar::setEvent);
//
//
//            repoCalendar.updateCalendar(id,calendar.getUser(),calendar.getEvent());
//        }
//    }


}
