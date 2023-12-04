package com.example.projectCalendar.controller;

import com.example.projectCalendar.model.Calendar;
import com.example.projectCalendar.model.User;
import com.example.projectCalendar.service.ServUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.OptionalLong;

@RestController
@RequestMapping("/user")
public class ContrUser {
    @Autowired
    ServUser servUser;

    @PostMapping
    public ResponseEntity createNewUser(@RequestBody User user){
        try {
            return ResponseEntity.ok(servUser.addUser(user));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }

    }

    @GetMapping
    public ResponseEntity geAllUser() {
        try {
            return ResponseEntity.ok(servUser.viewAllUsers());
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }

    }


    @GetMapping("/{id}")
    public ResponseEntity getUserById(@PathVariable int id){
        try {
            return ResponseEntity.ok(servUser.viewUserByID(id));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }

    }

    @PutMapping("/{id}")
    public ResponseEntity updateUser(@PathVariable int id, @RequestBody User user) {
        try {
            return ResponseEntity.ok(servUser.updateUser(id, user));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUserById(@PathVariable int id) {
        try {
            return ResponseEntity.ok(servUser.deleteUser(id));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }

    }

}
