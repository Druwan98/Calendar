package com.example.projectCalendar.service;

import com.example.projectCalendar.model.Calendar;
import com.example.projectCalendar.model.Event;
import com.example.projectCalendar.model.User;
import com.example.projectCalendar.repository.RepoUser;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.OptionalLong;

@Service
public class ServUser {

    @Autowired
    RepoUser repoUser;


    public User addUser(User user) throws Exception {
        try {
            Calendar calendar = new Calendar();
            calendar.setName("default calendar");
            calendar.setUser(user);

            user.getCalendars().add(calendar);

            return repoUser.save(user);
        } catch (Exception e) {
            throw new Exception(String.format("Error addUser"));
        }

    }


    public List<User> viewAllUsers() throws Exception {
        if (repoUser.findAll().isEmpty()) {
            return repoUser.findAll();
        } else {
            throw new Exception("Users not found");
        }

    }


    public Optional<User> viewUserByID(int id) throws Exception {
        if (repoUser.findById(id).isPresent()) {
            return repoUser.findById(id);
        } else {
            throw new Exception(String.format("User with ID %s not found", id));
        }

    }



    public User updateUser(int id, User updateUser) throws Exception {
        if (repoUser.findById(id).isPresent()) {

            User user = repoUser.findById(id).get();

            if (Objects.nonNull(updateUser.getUsername())) {
                user.setUsername(updateUser.getUsername());
            }

            if (Objects.nonNull(updateUser.getPassword())) {
                user.setPassword(updateUser.getPassword());
            }

            return repoUser.save(user);
        } else {
            throw new Exception(String.format("User with ID %s not found", id));
        }
    }

    public String deleteUser(int id) throws Exception {
        if (repoUser.findById(id).isPresent()) {
            repoUser.deleteById(id);
            return String.format("User with ID %s deleted", id);
        } else {
            throw new Exception(String.format("User with ID %s not exist", id));
        }


    }
}
