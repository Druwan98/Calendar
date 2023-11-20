package com.example.projectCalendar.controller;

import com.example.projectCalendar.model.Event;
import com.example.projectCalendar.service.ServEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/event")
public class ContrEvent {
    @Autowired
    ServEvent servEvent;

    @GetMapping("/viewall")
    public List<Event> events() {
        return servEvent.viewAllEvent();
    }

    @GetMapping("/view/{id}")
    public Optional<Event> viewUserByID(@PathVariable long id) {
        return Optional.ofNullable(servEvent.viewEvent(id));
    }

    @PostMapping("/create")
    public String createNewEvent(@RequestBody Event event) {
        servEvent.addEvent(event);
        return "new Event created.";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteEventById(@PathVariable long id) {
        servEvent.deleteEvent(id);
        return "Event id:" + id + "deleted";
    }

}
