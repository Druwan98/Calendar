package com.example.projectCalendar.controller;

import com.example.projectCalendar.model.Calendar;
import com.example.projectCalendar.model.User;
import com.example.projectCalendar.service.ServUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ContrUser {
    @Autowired
    ServUser servUser;

    @GetMapping("/view-all-users")
    public List<User> users() {
        return servUser.viewAllUser();
    }

    @PostMapping("/create-new-user")
    public String createNewUser(@RequestBody User user) {
        servUser.addUser(user);
        return "new user created: " + user.getUsername();
    }

    @DeleteMapping("/delete-user-byid")
    public String deleteUserById(@RequestParam long id) {
        servUser.deleteUser(id);
        return "User:" + id + " deleted";
    }
}
