package com.example.projectCalendar.controller;

import com.example.projectCalendar.model.Event;
import com.example.projectCalendar.service.ServEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/event")
public class ContrEvent {
    @Autowired
    ServEvent servEvent;

    @PostMapping("/{calendarID}/start/{startTime}/duration/{duration}")
    public ResponseEntity createNewEvent(@PathVariable int calendarID,
                                         @RequestBody Event event,
                                         @PathVariable LocalDateTime startTime,
                                         @PathVariable int duration){

        try {
            return ResponseEntity.ok(servEvent.createEvent(calendarID, event, startTime, duration));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/{calendarID}")
    public ResponseEntity viewAllEventsToCalendar(@PathVariable int calendarID){

        try {
            return ResponseEntity.ok(servEvent.viewEventsToCalendar(calendarID));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity updateEvent(@PathVariable int id, @RequestBody Event event){

        try {
            return ResponseEntity.ok(servEvent.updateEvent(id, event));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }


    @PutMapping("/{eventID}/user/{userID}")
    public ResponseEntity invitedUser(@PathVariable int eventID, @PathVariable int userID){

        try {
            return ResponseEntity.ok(servEvent.inviteUser(eventID, userID));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }



    @DeleteMapping("/{id}")
    public ResponseEntity deleteEvent(int id){

        try {
            return ResponseEntity.ok(servEvent.deleteEvent(id));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }

    }

}
