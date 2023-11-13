package com.example.projectCalendar.controller;

import com.example.projectCalendar.model.Calendar;
import com.example.projectCalendar.model.Event;
import com.example.projectCalendar.service.ServEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ContrEvent {
    @Autowired
    ServEvent servEvent;

    @GetMapping("/view-all-event")
    public List<Event> events() {
        return servEvent.viewAllEvent();
    }

    @PostMapping("/create-new-event")
    public String createNewEvent(@RequestBody Event event) {
        servEvent.addEvent(event);
        return "new Event created.";
    }

    @DeleteMapping("/delete-event-byid")
    public String deleteEventById(@RequestParam long id) {
        servEvent.deleteEvent(id);
        return "Event id:" + id + "deleted";
    }
}
