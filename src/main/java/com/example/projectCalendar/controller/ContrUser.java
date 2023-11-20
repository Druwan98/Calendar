package com.example.projectCalendar.controller;

import com.example.projectCalendar.model.User;
import com.example.projectCalendar.service.ServUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.OptionalLong;

@RestController
@RequestMapping("/user")
public class ContrUser {
    @Autowired
    ServUser servUser;

    @GetMapping("/view")
    public List<User> users() {
        return servUser.viewAllUser();
    }

    @GetMapping("/view/{id}")
    public Optional<User> viewUserByID(@PathVariable long id) {
        return Optional.ofNullable(servUser.viewUser(id));
    }


    @PostMapping("/create")
    public String createNewUser(@RequestBody User user) {
        servUser.addUser(user);
        return "new user created: " + user.getUsername();
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUserById(@PathVariable long id) {
        servUser.deleteUser(id);
        return "User:" + id + " deleted";
    }

}
