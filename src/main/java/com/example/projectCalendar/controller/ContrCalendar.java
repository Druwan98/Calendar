package com.example.projectCalendar.controller;

import com.example.projectCalendar.model.Calendar;
import com.example.projectCalendar.model.User;
import com.example.projectCalendar.service.ServCalendar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Duration;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/calendar")
public class ContrCalendar {
    @Autowired
    ServCalendar servCalendar;


    @PostMapping("/{userID}")
    public ResponseEntity createNewCalendar(@PathVariable int userID, @RequestBody Calendar calendar){
        try {
            return ResponseEntity.ok(servCalendar.createCalendar(userID, calendar));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }

    }

    @GetMapping("/{userID}")
    public ResponseEntity viewAllCalendarByUserID(@PathVariable int userID){
        try {
            return ResponseEntity.ok(servCalendar.viewAllCalendarByUserID(userID));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity updateCalendar(@PathVariable int id, @RequestBody Calendar calendar){
        try {
            return ResponseEntity.ok(servCalendar.updateCalendar(id, calendar));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteCalendar(@PathVariable int id){
        try {
            return ResponseEntity.ok(servCalendar.deleteCalendar(id));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }

    }

}
