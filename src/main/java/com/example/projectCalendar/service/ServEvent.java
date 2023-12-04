package com.example.projectCalendar.service;

import com.example.projectCalendar.model.Calendar;
import com.example.projectCalendar.model.Event;
import com.example.projectCalendar.model.User;
import com.example.projectCalendar.repository.RepoCalendar;
import com.example.projectCalendar.repository.RepoEvent;
import com.example.projectCalendar.repository.RepoUser;
import com.example.projectCalendar.util.HandleManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ServEvent {
    @Autowired
    RepoEvent repoEvent;
    @Autowired
    RepoCalendar repoCalendar;
    @Autowired
    RepoUser repoUser;

    public Event createEvent(int calendarID, Event event, LocalDateTime startTime, int duration) throws Exception{

        HandleManager handleManager = new HandleManager();

        if (repoCalendar.findById(calendarID).isPresent()){
            Calendar calendar = repoCalendar.findById(calendarID).orElse(null);

            event.setCalendar(calendar);

            handleManager.setRecurrenceTimeAndDuration(event, startTime, duration);
        }else {
            throw new Exception(String.format("Calendar with ID %s not found", calendarID));
        }

        return repoEvent.save(event);
    }


    public List<Event> viewEventsToCalendar(int calendarID) throws Exception{

        if (repoCalendar.findById(calendarID).isPresent()){
            Calendar calendar = repoCalendar.findById(calendarID).orElse(null);

            List<Event> events;
            events = calendar.getEvent();

            return events;

        } else {
            throw new Exception(String.format("Calendar with ID %s not exist", calendarID));
        }
    }



    public Event updateEvent(int id, Event updateEvent) throws Exception{

        if (repoEvent.findById(id).isPresent()){

            Event event = repoEvent.findById(id).get();

            if (Objects.nonNull(updateEvent.getTitle())){
                event.setTitle(updateEvent.getTitle());
            }

            if (Objects.nonNull(updateEvent.getDescription())){
                event.setDescription(updateEvent.getDescription());
            }

            if (Objects.nonNull(updateEvent.getDateTimeStart())){
                event.setDateTimeStart(updateEvent.getDateTimeStart());
            }

            if (Objects.nonNull(updateEvent.getDateTimeStart())){
                event.setDateTimeEnd(updateEvent.getDateTimeEnd());
            }

            return repoEvent.save(event);
        } else {
            throw new Exception(String.format("Event with ID %s not found", id));
        }

    }


    @Transactional
    public String inviteUser(int eventID, int userID) throws Exception{

        Event event = repoEvent.findById(eventID).get();
        User user = repoUser.findById(userID).get();

        if (event == null || user == null){

            throw new Exception("**Event or user not found**");
        } else {
            event.getParticipants().add(user);
            user.getEvents().add(event);
            repoEvent.save(event);
            repoUser.save(user);
            return "User invited ";
        }

    }


    public String deleteEvent(int id) throws Exception{

        if (repoEvent.findById(id).isPresent()){
            repoEvent.deleteById(id);
            return String.format("Event with ID %s deleted", id);
        } else {
            throw new Exception(String.format("Event with ID %s not found", id));
        }
    }
}
